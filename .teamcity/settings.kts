import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.PullRequests
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.pullRequests
import jetbrains.buildServer.configs.kotlin.vcs.PerforceVcsRoot

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

    vcsRoot(Prf)

    buildType(Bld)
}

object Bld : BuildType({
    name = "bld2"

    vcs {
        root(Prf)
        root(DslContext.settingsRoot)
    }

    features {
        commitStatusPublisher {
            vcsRootExtId = "${Prf.id}"
            publisher = swarm {
                serverUrl = "http://localhost:8114"
                username = "jetbrains"
                token = "credentialsJSON:1f58b7a5-7d75-4784-b690-5cd0bdca2f21"
                createSwarmTest = true
            }
        }
        pullRequests {
            vcsRootExtId = "${DslContext.settingsRoot.id}"
            provider = github {
                authType = token {
                    token = "credentialsJSON:e2782918-af14-4425-b2fb-8f850fd52a23"
                }
                filterAuthorRole = PullRequests.GitHubRoleFilter.MEMBER
            }
        }
    }
})

object Prf : PerforceVcsRoot({
    name = "prf"
    port = "localhost:1666"
    mode = stream {
        streamName = "//streamdepot/main"
        enableFeatureBranches = true
        branchSpec = "+:*"
    }
    userName = "jetbrains"
    password = "credentialsJSON:bdc9f64d-0b9c-4b56-b3de-3ab25538f405"
    workspaceOptions = """
        Options:        noallwrite clobber nocompress unlocked nomodtime rmdir
        Host:           %teamcity.agent.hostname%
        SubmitOptions:  revertunchanged
        LineEnd:        local
    """.trimIndent()
})
