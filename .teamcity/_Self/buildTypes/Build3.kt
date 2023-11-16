package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.matrix

object Build3 : BuildType({
    name = "build3"

    features {
        matrix {
            param("par1", listOf(
                value("1"),
                value("2")
            ))
        }
    }
})
