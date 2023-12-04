import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.vcs


version = "2023.11"

project {

    buildType(Par)
    buildType(Par1)
buildType(Par2)
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
        snapshot(Par2) {
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


object Par2 : BuildType({
    name = "Par2"

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


})
