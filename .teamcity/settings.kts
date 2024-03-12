import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.triggers.vcs

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

version = "2023.11"

project {

    buildType(Test2)
    buildType(BuildCore)
    buildType(Test1)
    buildType(BuildAll)
}

object BuildAll : BuildType({
    name = "BuildAll"

    vcs {
        root(DslContext.settingsRoot)
    }

    triggers {
        vcs {
        }
    }

    dependencies {
        snapshot(Test1) {
        }
        snapshot(Test2) {
        }
    }
})

object BuildCore : BuildType({
    name = "BuildCore"

    vcs {
        root(DslContext.settingsRoot, "+:Project")
    }
})

object Test1 : BuildType({
    name = "Test1"

    vcs {
        root(DslContext.settingsRoot, "+:Project")
    }

    steps {
        gradle {
            id = "gradle_runner"
            tasks = "clean build"
            buildFile = "Project/build.gradle"
            gradleWrapperPath = "Project"
            jdkHome = "%env.JDK_11%"
        }
    }

    dependencies {
        snapshot(BuildCore) {
        }
    }
})

object Test2 : BuildType({
    name = "Test2"

    vcs {
        root(DslContext.settingsRoot, "+:Project")
    }

    steps {
        gradle {
            name = "New build step"
            id = "gradle_runner"
            tasks = "clean build"
            buildFile = "Project/build.gradle"
            gradleWrapperPath = "Project"
            jdkHome = "%env.JDK_11%"
        }
    }

    features {
        parallelTests {
            numberOfBatches = 2
        }
    }

    dependencies {
        snapshot(BuildCore) {
        }
    }
})
