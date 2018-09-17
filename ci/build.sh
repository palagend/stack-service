#!/usr/bin/env bash
set -e

docker run --rm \
-v${HOME}/.m2/:/root/.m2 \
-v${WORKSPACE:-`pwd`}:/workspace \
-v${HOME}/.docker/config.json:/root/.docker/config.json \
-v/var/run/docker.sock:/var/run/docker.sock  \
-w /workspace \
-e ${BUILD_NUMBER:-0} \
founder/maven:alpine mvn clean install -DskipTests -Pjenkins