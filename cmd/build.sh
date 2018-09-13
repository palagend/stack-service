#!/usr/bin/env bash
set -e
test ${WORKSPACE:?WORKSPACE should been set!}
# 构建stack-services
curl -ulib:Founder123 -L# -o ${WORKSPACE}/.mvn/wrapper/maven-wrapper.jar ftp://ftp.fzyun.io/apache/maven-wrapper.jar
${WORKSPACE}/mvnw clean install -DskipTests -Pjenkins
