import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.buildCache
import jetbrains.buildServer.configs.kotlin.buildSteps.MavenBuildStep
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
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
    vcsRoot(HttpsGithubComChubatovaTigerMavenJunit)

    buildType(CleanTest)
    buildType(Build1)
    buildType(Build2)
    buildType(Consumer_1)
    buildType(Build1copy)

    params {
        param("teamcity.internal.feature.build.cache.enabled", "true")
        password("xs", "credentialsJSON:6e3ea57e-bd74-4743-8910-00bc691fe41d")
    }

    subProject(Maven)
}

object Build1 : BuildType({
    name = "build1"

    vcs {
        root(GitHub)

        cleanCheckout = true
    }

    steps {
        script {
            enabled = false
            scriptContent = """
                mkdir filestocache
                fsutil file createnew filestocache/file%build.counter% 2000000000
                dir
            """.trimIndent()
        }
        script {
            name = "small"
            enabled = false
            scriptContent = """
                mkdir filestocache1
                fsutil file createnew filestocache1/file1%build.counter% 200
                mkdir filestocache2
                fsutil file createnew filestocache2/file2%build.counter% 200
                dir
            """.trimIndent()
        }
        script {
            enabled = false
            scriptContent = "dir filestocache"
        }
    }

    features {
        buildCache {
            name = "mycaches"
            use = false
            publishOnlyChanged = false
            rules = """
                filestocache1
                filestocache2
            """.trimIndent()
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

object HttpsGithubComChubatovaTigerMavenJunit : GitVcsRoot({
    name = "https://github.com/ChubatovaTiger/mavenJunit"
    url = "https://github.com/ChubatovaTiger/mavenJunit"
    branch = "refs/heads/main"
})


object Maven : Project({
    name = "maven"

    buildType(ServiceMessage)
    buildType(ConsumeFromserviceMessage)
})

object ConsumeFromserviceMessage : BuildType({
    name = "consumeFromserviceMessage"

    params {
        param("system.maven.repo.local", "%system.agent.work.dir%")
    }

    vcs {
        root(HttpsGithubComChubatovaTigerMavenJunit)

        cleanCheckout = true
    }

    steps {
        script {
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = "dir .m2"
        }
        script {
            name = "publish"
            enabled = false
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = """echo "##teamcity[publishBuildCache cacheName='.m2' path='.m2']""""
        }
    }

    features {
        buildCache {
            name = "m2"
            publish = false
            publishOnlyChanged = false
            rules = "lkjlkjlkj"
        }
    }
})

object ServiceMessage : BuildType({
    name = "serviceMessage"

    params {
        param("system.maven.repo.local", "%system.agent.work.dir%")
    }

    vcs {
        root(HttpsGithubComChubatovaTigerMavenJunit)

        cleanCheckout = true
    }

    steps {
        maven {
            goals = "clean test"
            runnerArgs = """-Dmaven.test.failure.ignore=true -Dmaven.repo.local=%teamcity.build.checkoutDir%\.m2"""
            localRepoScope = MavenBuildStep.RepositoryScope.MAVEN_DEFAULT
        }
        script {
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = "dir .m2"
        }
        script {
            name = "publish"
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = """echo "##teamcity[publishBuildCache cacheName='m2' path='.m2']""""
        }
    }

    features {
        buildCache {
            enabled = false
            name = "mycaches"
            use = false
            publishOnlyChanged = false
            rules = """
                filestocache1
                filestocache2
            """.trimIndent()
        }
    }
})
