package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.matrix

object Build2 : BuildType({
    name = "build2"

    vcs {
        root(DslContext.settingsRoot)
    }

    features {
        matrix {
            param("OS", listOf(
                value("Linux"),
                value("Windows"),
                value("Windows2")
            ))
            param("env.JAVA_HOME", listOf(
                value("%env.JDK_21_0%", label = "JDK 21"),
                value("%env.JDK_11%", label = "JDK 11")
            ))
            param("custom2", listOf(
                value("a"),
                value("b")
            ))
            param("customwitjlabel", listOf(
                value("a"),
                value("B", label = "my labelB")
            ))
        }
    }
})
