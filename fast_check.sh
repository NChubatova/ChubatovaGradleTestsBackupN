#!/usr/bin/env bash
#gradle build --scan


function runInInternalBuilder() {
    #docker run python
    docker ps -a
}
function gradleInBuilder() {
    runInInternalBuilder 
    echo hi
    exit 1
}
set -e
gradleInBuilder
