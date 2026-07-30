# EasyAIoT Boot3 P0 regression smoke (Windows PowerShell)
# Usage: powershell -File .scripts/docker/regression-smoke.ps1
$ErrorActionPreference = 'Continue'
$fail = 0
$pass = 0
$rows = @()

function Add-Result($id, $ok, $detail) {
  $script:rows += [pscustomobject]@{ Id = $id; Ok = $ok; Detail = $detail }
  if ($ok) { $script:pass++ } else { $script:fail++ }
  $mark = if ($ok) { 'PASS' } else { 'FAIL' }
  Write-Host ("[{0}] {1} - {2}" -f $mark, $id, $detail)
}

function Test-Http($id, $url, $expectCodes = @(200)) {
  try {
    $r = Invoke-WebRequest -Uri $url -UseBasicParsing -TimeoutSec 12 -MaximumRedirection 5
    $code = [int]$r.StatusCode
    Add-Result $id ($expectCodes -contains $code) ("HTTP $code $url")
  } catch {
    $resp = $_.Exception.Response
    if ($resp) {
      $code = [int]$resp.StatusCode
      Add-Result $id ($expectCodes -contains $code) ("HTTP $code $url")
    } else {
      Add-Result $id $false ("ERR $url :: $($_.Exception.Message)")
    }
  }
}

Write-Host '=== Container health ==='
$needHealthy = @(
  'postgres-server','redis-server','nacos-server','kafka-server','minio-server',
  'milvus-server','emqx-server','tdengine-server','srs-server','zlmediakit-server',
  'nodered-server','fuxa-server','iot-gateway','iot-system','iot-infra','iot-device',
  'iot-file','iot-message','iot-dataset','iot-node','iot-sink','iot-tdengine',
  'iot-visualize','web-service','app-service','visualize-service','ai-service','video-service'
)
$needUp = @('iot-gb28181','easyaiot-node-agent')

$ps = docker ps -a --format "{{.Names}}|{{.Status}}" 2>$null
$map = @{}
foreach ($line in $ps) {
  $p = $line -split '\|', 2
  if ($p.Count -eq 2) { $map[$p[0]] = $p[1] }
}

foreach ($name in $needHealthy) {
  $st = $map[$name]
  if (-not $st) { Add-Result "ctr:$name" $false 'missing'; continue }
  Add-Result "ctr:$name" ($st -match 'healthy') $st
}
foreach ($name in $needUp) {
  $st = $map[$name]
  if (-not $st) { Add-Result "ctr:$name" $false 'missing'; continue }
  Add-Result "ctr:$name" ($st -match '^Up') $st
}

Write-Host '=== HTTP probes ==='
Test-Http 'http:web' 'http://127.0.0.1:8888/'
Test-Http 'http:druid-gw' 'http://127.0.0.1:48080/druid/index.html'
Test-Http 'http:druid-web' 'http://127.0.0.1:8888/druid/index.html' @(200,301,302)
Test-Http 'http:ai' 'http://127.0.0.1:5000/actuator/health'
Test-Http 'http:video' 'http://127.0.0.1:6000/actuator/health'
Test-Http 'http:nacos' 'http://127.0.0.1:8848/nacos/' @(200,302)
Test-Http 'http:zlm-root' 'http://127.0.0.1:6080/'
# Windows Docker Desktop 下 SRS 使用 network_mode=host，API 在 Linux VM 内；用容器内探测
try {
  $srsOut = docker exec srs-server /bin/bash /usr/local/bin/srs-healthcheck.sh 2>&1
  Add-Result 'http:srs-api' ($LASTEXITCODE -eq 0) ("docker-exec srs-healthcheck exit=$LASTEXITCODE $srsOut")
} catch {
  Add-Result 'http:srs-api' $false $_.Exception.Message
}
Test-Http 'http:nodered' 'http://127.0.0.1:1880/'
Test-Http 'http:fuxa' 'http://127.0.0.1:1881/'

# ZLM API with secret from local config (trim CRLF); never print secret
$cfg = Join-Path $PSScriptRoot '..\zlmediakit\conf\config.ini'
if (Test-Path $cfg) {
  $secretLine = Select-String -Path $cfg -Pattern '^\s*secret=' | Select-Object -First 1
  if ($secretLine) {
    $secret = ($secretLine.Line -split '=',2)[1].Trim()
    $u = "http://127.0.0.1:6080/index/api/getServerConfig?secret=$([uri]::EscapeDataString($secret))"
    try {
      $r = Invoke-WebRequest -Uri $u -UseBasicParsing -TimeoutSec 12
      $ok = ($r.StatusCode -eq 200) -and ($r.Content -match '"code"\s*:\s*0')
      Add-Result 'http:zlm-api' $ok ("HTTP $($r.StatusCode) getServerConfig code-check")
    } catch {
      Add-Result 'http:zlm-api' $false $_.Exception.Message
    }
  } else {
    Add-Result 'http:zlm-api' $false 'secret not found in config.ini'
  }
} else {
  Add-Result 'http:zlm-api' $false "config missing: $cfg"
}

Write-Host ''
Write-Host ("SUMMARY pass={0} fail={1}" -f $pass, $fail)
$repoRoot = Resolve-Path (Join-Path $PSScriptRoot '..\..')
$outDir = Join-Path $repoRoot '.build-cache\migrate-logs'
New-Item -ItemType Directory -Force -Path $outDir | Out-Null
$outFile = Join-Path $outDir ("regression-smoke-{0}.txt" -f (Get-Date -Format 'yyyyMMdd-HHmmss'))
$rows | Format-Table -AutoSize | Out-String | Set-Content -Encoding UTF8 $outFile
"SUMMARY pass=$pass fail=$fail" | Add-Content -Encoding UTF8 $outFile
Write-Host "Report: $outFile"
if ($fail -gt 0) { exit 1 } else { exit 0 }
