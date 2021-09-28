function runInInternalBuilder() {
docker run --entrypoint "/sources/gradlew" custom-gradle
}
function gradleInBuilder() {
    runInInternalBuilder
    
}
set -e
gradleInBuilder 
