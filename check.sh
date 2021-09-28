#!/usr/bin/env bash
function runInInternalBuilder() {
docker run custom-gradle $@ --detach=true

}
function gradleInBuilder() {
    runInInternalBuilder ./gradlew ${GRADLE_RUN_PARAMS} $@
}
set -e
gradleInBuilder test --stacktrace --scan "$@"
