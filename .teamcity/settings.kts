import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.script
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

    buildType(Par)
    buildType(Par0)
    buildType(Par1)
}

object Par : BuildType({
    name = "Par"

    params {
        param("env.BranchDefault", "%teamcity.build.branch.is_default%")
        param("env.Triggered", "%teamcity.build.triggeredBy%")
        param("env.rootBranch", "${DslContext.settingsRoot.paramRefs["branch"]}")
        param("env.Branch", "%teamcity.build.branch%")
        param("env.rootAuth", "%vcsroot.authMethod%")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        gradle {
            id = "gradle_runner"
            tasks = "clean build"
            jdkHome = "%env.JDK_11_0%"
        }
        script {
            id = "simpleRunner"
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = """
                echo "%env.Branch%"
                echo "%env.BranchDefault%"
                echo "%env.rootAuth%"
                echo "%env.rootBranch%"
                echo "%env.Triggered%"
            """.trimIndent()
        }
    }

    triggers {
        vcs {
        }
    }

    dependencies {
        snapshot(Par1) {
            reuseBuilds = ReuseBuilds.NO
        }
    }
})

object Par0 : BuildType({
    name = "Par0"

    params {
        param("env.BranchDefault", "%teamcity.build.branch.is_default%")
        param("env.Triggered", "%teamcity.build.triggeredBy%")
        param("env.rootBranch", "${DslContext.settingsRoot.paramRefs["branch"]}")
        param("env.Branch", "%teamcity.build.branch%")
        param("env.rootAuth", "%vcsroot.authMethod%")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        gradle {
            id = "gradle_runner"
            tasks = "clean build"
            jdkHome = "%env.JDK_11_0%"
        }
        script {
            id = "simpleRunner"
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = """
                echo "%env.Branch%"
                echo "%env.BranchDefault%"
                echo "%env.rootAuth%"
                echo "%env.rootBranch%"
                echo "%env.Triggered%"
            """.trimIndent()
        }
    }

    triggers {
        vcs {
        }
    }

    dependencies {
        snapshot(Par1) {
            reuseBuilds = ReuseBuilds.NO
        }
    }
})

object Par1 : BuildType({
    name = "Par1"

    params {
        param("env.BranchDefault", "%teamcity.build.branch.is_default%")
        param("env.Triggered", "%teamcity.build.triggeredBy%")
        param("env.rootBranch", "${DslContext.settingsRoot.paramRefs["branch"]}")
        param("env.Branch", "%teamcity.build.branch%")
        param("env.rootAuth", "%vcsroot.authMethod%")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        gradle {
            id = "gradle_runner"
            tasks = "clean build"
            jdkHome = "%env.JDK_11_0%"
        }
        script {
            id = "simpleRunner"
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = """
                echo "%env.Branch%"
                echo "%env.BranchDefault%"
                echo "%env.rootAuth%"
                echo "%env.rootBranch%"
                echo "%env.Triggered%"
            """.trimIndent()
        }
    }

    triggers {
        vcs {
        }
    }
})
