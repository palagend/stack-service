#!/usr/bin/env bash
set -e
test ${WORKSPACE:?WORKSPACE should been set!}
# 构建stack-service
${WORKSPACE}/mvnw clean install -DskipTests -Pjenkins
