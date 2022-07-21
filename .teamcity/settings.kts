import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script



version = "2022.04"

project {

    buildType(Arts)


}

object Arts : BuildType({
    name = "arts"

    artifactRules = "*.txt => s3arts"

    steps {
        script {
            scriptContent = "echo a > %build.number%.txt"
        }
    }
})
