#!/usr/bin/env bash
#gradle build --scan


function runInInternalBuilder() {
    docker run python
}
function gradleInBuilder() {
    runInInternalBuilder 
    echo hi
}
set -e
gradleInBuilder
