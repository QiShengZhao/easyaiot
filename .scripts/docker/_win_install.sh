#!/usr/bin/env bash
set -euo pipefail
export PATH="/c/Program Files/Docker/Docker/resources/bin:/c/Program Files/Docker/Docker/resources/cli-plugins:${PATH:-}"
export MSYS_NO_PATHCONV=1
export MSYS2_ARG_CONV_EXCL="*"
export EASYAIOT_DEPLOY_PROFILE="${EASYAIOT_DEPLOY_PROFILE:-full}"

ROOT="$(cd "$(dirname "$0")/../.." && pwd)"
cd "$ROOT"

echo "[win] ROOT=$ROOT"
echo "[win] PROFILE=$EASYAIOT_DEPLOY_PROFILE"
echo "[win] docker=$(command -v docker || true)"
docker version || true

CMD="${1:-check}"
shift || true
echo "[win] running: install_linux.sh $CMD $*"
exec bash "$ROOT/.scripts/docker/install_linux.sh" "$CMD" "$@"
