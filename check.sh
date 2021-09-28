function runInInternalBuilder() {
docker run --entrypoint "/sources/a.sh" custom-gradle
}
function gradleInBuilder() {
    runInInternalBuilder
    
}
set -e
gradleInBuilder 
