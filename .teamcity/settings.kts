import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.schedule

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

    buildType(BuildFeature_1)
    buildType(Mail)
}

object BuildFeature_1 : BuildType({
    id("BuildFeature")
    name = "buildFeature"
})

object Mail : BuildType({
    name = "mail"

    params {
        param("sleep", "0.5s")
        param("a", "a")
        param("email", "n.chubatova@gmail.com")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            scriptContent = """
                echo "##teamcity[notification notifier='email' message='abc|nzalando|ngoogle' subject='bu' address='%email%']"
                # sleep %sleep%
                echo "##teamcity[notification notifier='email' message='abc1|nzalando|ngoogle' subject='bu1' address='%email%']"
            """.trimIndent()
        }
    }

    triggers {
        schedule {
            schedulingPolicy = cron {
                seconds = "0/15"
                minutes = "*"
            }
            branchFilter = ""
            triggerBuild = always()
            withPendingChangesOnly = false
        }
    }
})
