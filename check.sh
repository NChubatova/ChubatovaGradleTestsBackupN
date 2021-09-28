#!/usr/bin/env bash
function runInInternalBuilder() {
docker run --entrypoint "/q/gradlew" custom-gradle
}
function gradleInBuilder() {
    runInInternalBuilder
    
}
set -e
gradleInBuilder 
