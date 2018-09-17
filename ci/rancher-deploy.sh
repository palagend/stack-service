#!/usr/bin/env bash
set -e
test ${WORKSPACE:?WORKSPACE MUST be set!}
# 部署stack-service
rancher-compose -p ycbs -f ${WORKSPACE}/rancher/docker-compose.yml -r ${WORKSPACE}/rancher/rancher-compose.yml up -d -p -c --force-recreate
