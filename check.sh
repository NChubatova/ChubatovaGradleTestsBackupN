function runInInternalBuilder() {
echo a
}
function gradleInBuilder() {
    ./gradlew ${GRADLE_RUN_PARAMS} $@
}
set -e
gradleInBuilder test --stacktrace "$@"
