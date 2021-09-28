#!/usr/bin/env bash
#gradle build --scan


function runInInternalBuilder() {
    docker run python "vc"
    echo code $?
    docker ps -a
    ./gradlew build --scan
    echo code $?
    #echo hi
}
function gradleInBuilder() {
    runInInternalBuilder 
    #echo hi
    
}
#set -e
gradleInBuilder
