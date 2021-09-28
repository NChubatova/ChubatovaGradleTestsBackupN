#!/usr/bin/env bash
function runInInternalBuilder() {
docker run custom-gradle /q/gradlew test --stacktrace
}
function gradleInBuilder() {
    runInInternalBuilder
    
}
set -e
gradleInBuilder 
