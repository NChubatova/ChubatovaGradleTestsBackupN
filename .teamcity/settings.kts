import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.PullRequests
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.pullRequests
import jetbrains.buildServer.configs.kotlin.buildSteps.script

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

    buildType(Sdkfjhjh)
    buildType(Csp)

    params {
        param("a", "an")
    }
}

object Csp : BuildType({
    name = "csp"

    vcs {
        root(DslContext.settingsRoot)
    }

    features {
        commitStatusPublisher {
            publisher = github {
                githubUrl = "https://api.github.com"
                authType = personalToken {
                    token = "credentialsJSON:39f904aa-9228-4d00-b328-1ab1c1e6c2c6"
                }
            }
        }
        pullRequests {
            provider = github {
                authType = token {
                    token = "credentialsJSON:39f904aa-9228-4d00-b328-1ab1c1e6c2c6"
                }
                filterAuthorRole = PullRequests.GitHubRoleFilter.MEMBER
            }
        }
    }
})

object Sdkfjhjh : BuildType({
    name = "sdkfjhjh"

    steps {
        script {
            scriptContent = "echo b"
        }
    }

    requirements {
        contains("teamcity.agent.name", "Default")
    }
})
