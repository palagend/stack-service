#!/usr/bin/env bash
set -e
test ${WORKSPACE:?WORKSPACE MUST be set!}
# 部署stack-services
rancher-compose -p ycbs -f ${WORKSPACE}/compose/docker-compose.yml -r ${WORKSPACE}/compose/rancher-compose.yml up -d -p -c --force-recreate
