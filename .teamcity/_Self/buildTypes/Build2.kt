package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.approval

object Build2 : BuildType({
    name = "build2"

    vcs {
        root(DslContext.settingsRoot)
    }

    features {
        approval {
            approvalRules = "user:admin"
        }
    }
})
