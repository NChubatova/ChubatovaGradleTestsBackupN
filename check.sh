#!/usr/bin/env bash
function runInInternalBuilder() {
docker run custom-gradle /q/a.sh
#/q/gradlew test --stacktrace --no-daemon
}
function gradleInBuilder() {
    runInInternalBuilder
    
}
set -e
gradleInBuilder 
