#!/usr/bin/env bash
function runInInternalBuilder() {
docker run custom-gradle ./gradlew test --stacktrace --no-daemon
#/q/gradlew test --stacktrace --no-daemon
}
function gradleInBuilder() {
    runInInternalBuilder
    
}
set -e
gradleInBuilder 
