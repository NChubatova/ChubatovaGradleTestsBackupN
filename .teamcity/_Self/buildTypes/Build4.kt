package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.approval
import jetbrains.buildServer.configs.kotlin.matrix

object Build4 : BuildType({
    name = "build4"

    features {
        matrix {
            param("par2", listOf(
                value("3"),
                value("343")
            ))
        }
        approval {
            approvalRules = "user:admin"
        }
    }
})
