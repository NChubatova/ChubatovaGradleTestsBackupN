#!/usr/bin/env bash
#gradle build --scan


function runInInternalBuilder() {
    #docker run python
    docker ps -a
    exit 2
}
function gradleInBuilder() {
    runInInternalBuilder 
    echo hi
    
}
set -e
gradleInBuilder
