import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2022.04"

project {

    vcsRoot(HttpsGithubComChubatovaTigerDotNetTestsSamples)

    buildType(Cba_4)
    buildType(Dep)

    params {
        param("projpar", "b6-ranch")
    }
}

object Cba_4 : BuildType({
    id("Cba")
    name = "cba"

    artifactRules = "parsec*=>."
    buildNumberPattern = "%build.counter%-b6-ranch-change4"

    params {
        param("aa", "b6-ranch2change5")
        param("env.env", "envb6-ranch")
        password("parsec", "credentialsJSON:25aa9774-b33d-4ec7-9045-8ec357f54265")
    }

    vcs {
        root(HttpsGithubComChubatovaTigerDotNetTestsSamples, "+:TestProject1 => TestProject1")
        root(DslContext.settingsRoot, "-:manyfiles ")

        cleanCheckout = true
    }

    steps {
        gradle {
            tasks = "clean build"
            gradleWrapperPath = ""
        }
        script {
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = "echo b6-ranch"
        }
        script {
            name = "New build step"
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = "echo %parsec% > parsecb6-ranch.txt"
        }
        script {
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = "exit 1"
        }
        script {
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = """
                echo checkoutDirLS
                ls
            """.trimIndent()
        }
    }

    failureConditions {
        testFailure = true
        nonZeroExitCode = false
    }

    features {
        commitStatusPublisher {
            vcsRootExtId = "${DslContext.settingsRoot.id}"
            publisher = github {
                githubUrl = "https://api.github.com"
                authType = personalToken {
                    token = "credentialsJSON:25aa9774-b33d-4ec7-9045-8ec357f54265"
                }
            }
        }
        parallelTests {
            numberOfBatches = 3
        }
    }
})

object Dep : BuildType({
    name = "dep"

    vcs {
        root(DslContext.settingsRoot)
    }
})

object HttpsGithubComChubatovaTigerDotNetTestsSamples : GitVcsRoot({
    name = "https://github.com/ChubatovaTiger/DotNetTestsSamples"
    url = "https://github.com/ChubatovaTiger/DotNetTestsSamples"
    branch = "refs/heads/master"
})
