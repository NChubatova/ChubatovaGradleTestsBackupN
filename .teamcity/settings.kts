import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot


version = "2022.04"

project {

    vcsRoot(HttpsGithubComChubatovaTigerDotNetTestsSamples)

    buildType(Cba_4)

    params {
        param("projpar", "master")
    }
}

object Cba_4 : BuildType({
    id("Cba")
    name = "cba"

    artifactRules = "parsec*=>."
    buildNumberPattern = "%build.counter%-master"

    params {
        param("aa", "master")
        param("env.env", "envmaster")
        password("parsec", "credentialsJSON:25aa9774-b33d-4ec7-9045-8ec357f54265")
    }

    vcs {
        root(DslContext.settingsRoot)
        root(HttpsGithubComChubatovaTigerDotNetTestsSamples)
    }

    steps {
        gradle {
            tasks = "clean build"
            gradleWrapperPath = ""
        }
        script {
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = "echo master"
        }
        script {
            name = "New build step"
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = "echo %parsec% > parsecmaster.txt"
        }
        script {
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = "exit 1"
        }
    }

    failureConditions {
        testFailure = false
        nonZeroExitCode = false
    }

    features {
        parallelTests {
            numberOfBatches = 3
        }
        commitStatusPublisher {
            vcsRootExtId = "${DslContext.settingsRoot.id}"
            publisher = github {
                githubUrl = "https://api.github.com"
                authType = personalToken {
                    token = "credentialsJSON:25aa9774-b33d-4ec7-9045-8ec357f54265"
                }
            }
        }
    }

    requirements {
        contains("teamcity.agent.name", "Default")
    }
})

object HttpsGithubComChubatovaTigerDotNetTestsSamples : GitVcsRoot({
    name = "https://github.com/ChubatovaTiger/DotNetTestsSamples"
    url = "https://github.com/ChubatovaTiger/DotNetTestsSamples"
    branch = "refs/heads/master"
})
