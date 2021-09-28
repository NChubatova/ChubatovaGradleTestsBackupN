#!/usr/bin/env bash
#gradle build --scan


function runInInternalBuilder() {
    docker run python
}
function gradleInBuilder() {
    runInInternalBuilder "exit 1" $@
}
set -e
gradleInBuilder  "$@"
