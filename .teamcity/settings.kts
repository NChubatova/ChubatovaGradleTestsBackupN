import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.buildCache
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

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

version = "2022.10"

project {

    vcsRoot(GitHub)

    buildType(CleanTest)
    buildType(CleanTestdownlo)
    buildType(Build1)
    buildType(Build2)
    buildType(Consumer_1)
    buildType(Build1copy)

    params {
        param("teamcity.internal.feature.build.cache.enabled", "true")
        password("xs", "credentialsJSON:68318b42-2f72-46e1-90cb-59e8394e3d59")
    }
}

object Build1 : BuildType({
    name = "build1"

    vcs {
        root(GitHub)

        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = """
                mkdir filestocache
                fsutil file createnew filestocache/file%build.counter% 2000000000
                dir
            """.trimIndent()
        }
        script {
            scriptContent = "dir filestocache"
        }
    }

    features {
        buildCache {
            name = "mycaches"
            use = false
            publishOnlyChanged = false
            rules = "filestocache"
        }
    }
})

object Build1copy : BuildType({
    name = "build1copy"

    vcs {
        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = """
                mkdir filestocache2
                fsutil file createnew filestocache2/file%build.counter% 2000000000
                dir
            """.trimIndent()
        }
        script {
            scriptContent = "echo contentCache > art.txt"
        }
    }

    features {
        buildCache {
            name = "mycaches"
            use = false
            publishOnlyChanged = false
            rules = "filestocache2"
        }
    }
})

object Build2 : BuildType({
    name = "build2"

    vcs {
        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = """
                mkdir filestocache2
                echo a > filestocache2/1-2
                echo b > filestocache2/2-2
                echo c > filestocache2/%build.counter%m-2
                dir
            """.trimIndent()
        }
    }

    features {
        buildCache {
            name = "chubatovacache"
            use = false
            rules = "filestocache2"
        }
    }
})

object CleanTest : BuildType({
    name = "cleanTest"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            scriptContent = "echo a > a%build.counter%.txt"
        }
    }

    features {
        buildCache {
            name = "cleantest"
            publishOnlyChanged = false
            rules = """C:\runnginx.bat"""
        }
    }
})

object CleanTestdownlo : BuildType({
    name = "cleanTestdownlo"

    vcs {
        root(DslContext.settingsRoot)

        branchFilter = "+:<default>"
    }

    steps {
        script {
            scriptContent = """
                echo a > a%build.counter%.txt
                ping 127.0.0.1 -n 60 > nul
            """.trimIndent()
        }
    }

    features {
        buildCache {
            name = "cleantest"
            publishOnlyChanged = false
            rules = "a%build.counter%.txt"
        }
    }
})

object Consumer_1 : BuildType({
    id("Consumer")
    name = "consumer"

    vcs {
        root(GitHub)

        cleanCheckout = true
        branchFilter = "+:<default>"
    }

    steps {
        script {
            enabled = false
            scriptContent = """
                mkdir filestocache2
                echo a > filestocache2/1-2
                echo b > filestocache2/2-2
                echo c > filestocache2/%build.counter%m-2
                dir
            """.trimIndent()
        }
        script {
            scriptContent = "dir filestocache"
        }
    }

    features {
        buildCache {
            name = "mycaches"
            publish = false
            publishOnlyChanged = false
            rules = "filestocache"
        }
    }
})

object GitHub : GitVcsRoot({
    name = "GitHub"
    url = "git@github.com:ChubatovaTiger/ChubatovaGradleTestsBackup.git"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/(buildCache*)"
    authMethod = uploadedKey {
        uploadedKey = "rsaopensshnew"
        passphrase = "credentialsJSON:f6e56813-d355-4aed-ab01-7c7eb56b69bb"
    }
})
