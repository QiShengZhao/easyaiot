#!/bin/sh
# ZLMediaKit 健康检查：读取 [api] secret，剔除 CRLF 后用 data-urlencode 调用 getServerConfig
# Windows 挂载的 config.ini 常为 CRLF，直接拼到 URL 会触发：curl (3) URL rejected: Malformed input
set -eu

CFG="${ZLM_CONFIG_PATH:-/conf/config.ini}"
HTTP_PORT="${ZLM_HTTP_PORT:-80}"

SECRET=""
if [ -f "$CFG" ]; then
  LINE=$(grep '^[[:space:]]*secret=' "$CFG" 2>/dev/null | head -1 || true)
  SECRET=$(printf '%s' "$LINE" | cut -d= -f2- | tr -d '\r\n' | sed 's/^[[:space:]]*//;s/[[:space:]]*$//')
fi

BASE="http://127.0.0.1:${HTTP_PORT}/index/api/getServerConfig"
if [ -n "$SECRET" ]; then
  curl -fsS -G "$BASE" --data-urlencode "secret=${SECRET}" >/dev/null
else
  curl -fsS "$BASE" >/dev/null
fi
