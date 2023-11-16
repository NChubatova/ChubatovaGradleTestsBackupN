package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.matrix

object Build4 : BuildType({
    name = "build4"

    features {
        matrix {
            param("custim12", listOf(
                value("13"),
                value("15")
            ))
        }
    }
})
