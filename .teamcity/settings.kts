import jetbrains.buildServer.configs.kotlin.*
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

version = "2022.10"

project {

    buildType(Requirem_Requi)

    params {
        param("a", "1")
        param("w", "2")
    }

    subProject(AnotherProj)
}

object Requirem_Requi : BuildType({
    id("Requi")
    name = "requi"

    params {
        param("par1", "л")
    }

    steps {
        script {
            scriptContent = "echo 1"

        }
        script {
            scriptContent = "echo 1"

        }
    }
})


object AnotherProj : Project({
    id = AbsoluteId("AnotherProj")
    name = "another proj"

    buildType(AnotherProj_Conf)
})

object AnotherProj_Conf : BuildType({
    id = AbsoluteId("AnotherProj_Conf")
    name = "conf"
})
