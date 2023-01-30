import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script



version = "2022.04"

project {

    buildType(Gh)
}

object Gh : BuildType({
    name = "gh"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            scriptContent = "ls"
        }
    }
})
