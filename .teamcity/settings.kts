import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.pullRequests
import jetbrains.buildServer.configs.kotlin.projectFeatures.youtrack
import jetbrains.buildServer.configs.kotlin.sharedResource

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

version = "2022.10"

project {

    buildType(Glpr)

    features {
        sharedResource {
            id = "PROJECT_EXT_2"
            name = "resname"
            resourceType = infinite()
        }
        youtrack {
            id = "PROJECT_EXT_4"
            displayName = "dsplname"
            //host = "http://localhost:8111"
            userName = ""
            password = ""
            projectExtIds = "TW"
            accessToken = "credentialsJSON:5f5aa34c-94be-48a4-9940-b0da5c3e7ed8"
        }
    }
}

object Glpr : BuildType({
    name = "glpr"

    params {
        param("d", "d")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    features {
        pullRequests {
            vcsRootExtId = "${DslContext.settingsRoot.id}"
            provider = gitlab {
                authType = vcsRoot()
            }
            param("secure:accessToken", "credentialsJSON:e350ea17-9bf3-4e6c-9650-8635fd4b0432")
        }
    }
})
