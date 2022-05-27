import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.PullRequests
import jetbrains.buildServer.configs.kotlin.buildFeatures.pullRequests
import jetbrains.buildServer.configs.kotlin.triggers.vcs
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

    vcsRoot(HttpsGithubComChubatovaTigerManyPullRequests)

    buildType(Build)
    buildType(Prs)
}

object Build : BuildType({
    name = "Build"

    params {
        param("sd", "sfdvfgd")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    triggers {
        vcs {
        }
    }
})

object Prs : BuildType({
    name = "prs"

    vcs {
        root(HttpsGithubComChubatovaTigerManyPullRequests)
    }

    features {
        pullRequests {
            provider = github {
                authType = token {
                    token = "credentialsJSON:bb8b5b90-bd37-491c-837a-dfe49c0a8c9e"
                }
                filterAuthorRole = PullRequests.GitHubRoleFilter.MEMBER
            }
        }
    }
})

object HttpsGithubComChubatovaTigerManyPullRequests : GitVcsRoot({
    name = "https://github.com/ChubatovaTiger/manyPullRequests"
    url = "https://github.com/ChubatovaTiger/manyPullRequests"
    branch = "refs/heads/main"
})
