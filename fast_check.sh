#!/usr/bin/env bash
#gradle build --scan


function runInInternalBuilder() {
    docker run python "vc"
    #?
    docker ps -a
    ./gradlew test --stacktrace
    #?
    echo hi
}
function gradleInBuilder() {
    runInInternalBuilder 
    echo hi
    
}
#set -e
gradleInBuilder
