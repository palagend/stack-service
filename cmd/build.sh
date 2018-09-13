#!/usr/bin/env bash
set -e
test ${WORKSPACE:?WORKSPACE should been set!}
# 构建stack-services
${WORKSPACE}/mvnw clean install -DskipTests -Pjenkins
