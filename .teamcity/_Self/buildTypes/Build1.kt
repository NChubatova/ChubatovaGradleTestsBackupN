package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.matrix

object Build1 : BuildType({
    name = "build1"

    features {
        matrix {
            param("a", listOf(
                value("a"),
                value("b")
            ))
        }
    }
})
