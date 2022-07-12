import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.buildSteps.sshExec
import jetbrains.buildServer.configs.kotlin.projectFeatures.buildReportTab
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

version = "2022.04"

project {
    description = "Contains all other projects"

    params {
        param("a", "a")
        password("asec", "zxxee347964c98cda13775d03cbe80d301b")
    }

    features {
        buildReportTab {
            id = "PROJECT_EXT_1"
            title = "Code Coverage"
            startPage = "coverage.zip!index.html"
        }
    }

    cleanup {
        baseRule {
            preventDependencyCleanup = false
        }
    }

    subProject(Sshagent)
    subProject(A)
    subProject(Abc)
}


object A : Project({
    name = "a"

    vcsRoot(A_HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup)

    buildType(A_A)

    cleanup {
        baseRule {
            all(days = 80)
        }
    }
})

object A_A : BuildType({
    name = "a"

    params {
        param("BUILD0", "BUILD0")
    }

    vcs {
        root(A_HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup)
    }

    steps {
        gradle {
            tasks = "clean build"
            jvmArgs = "-Xmx1g"
        }
    }
})

object A_HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup : GitVcsRoot({
    name = "https://github.com/ChubatovaTiger/ChubatovaGradleTestsBackup"
    url = "https://github.com/ChubatovaTiger/ChubatovaGradleTestsBackup"
    branch = "refs/heads/manytests"
})


object Abc : Project({
    name = "abc"

    buildType(Abc_Build0)
})

object Abc_Build0 : BuildType({
    name = "BUILD0"

    params {
        password("SECURE_VALUE", "zxxf440794396b2a1343fda9c27db829fd1e390f302447a5a16")
    }
})


object Sshagent : Project({
    name = "sshagent"

    buildType(Sshagent_Build2)
    buildType(Sshagent_Build1)
    buildType(Sshagent_Sshagent)
})

object Sshagent_Build1 : BuildType({
    name = "BUILD1"

    params {
        password("SECURE_VALUE_TO_STEAL", "zxx9ff8ea171380a9cbc91c6a031be54b4f", display = ParameterDisplay.HIDDEN)
    }

    steps {
        script {
            scriptContent = "echo %SECURE_VALUE_TO_STEAL% > secret.txt"
        }
    }
})

object Sshagent_Build2 : BuildType({
    name = "BUILD2"

    artifactRules = "+:secret.txt => ."
})

object Sshagent_Sshagent : BuildType({
    name = "sshagent"

    buildNumberPattern = "%build.counter%nastya"

    steps {
        sshExec {
            commands = "echo a"
            targetUrl = "10.128.93.99"
            authMethod = uploadedKey {
                username = "ubuntu"
                passphrase = "zxx68b065e3e10cc85e775d03cbe80d301b"
                key = "rsaopensshnew"
            }
        }
    }
})
