import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
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

version = "2021.2"

project {

    vcsRoot(HttpsGithubComChubatovaTigerChubatovaGradleTestsBackupRefsHeadsMaster11)

    buildType(Dependent)

    subProject(HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup)
}

object Dependent : BuildType({
    name = "dependent"

    vcs {
        root(HttpsGithubComChubatovaTigerChubatovaGradleTestsBackupRefsHeadsMaster11)
    }

    steps {
        gradle {
            tasks = "clean build"
            gradleWrapperPath = ""
        }
    }

    requirements {
        contains("teamcity.agent.name", "Default Agent")
    }
})

object HttpsGithubComChubatovaTigerChubatovaGradleTestsBackupRefsHeadsMaster11 : GitVcsRoot({
    name = "https://github.com/ChubatovaTiger/ChubatovaGradleTestsBackup#refs/heads/master (1) (1)"
    url = "git@github.com:ChubatovaTiger/ChubatovaGradleTestsBackup.git"
    branch = "refs/heads/split"
    branchSpec = """
        refs/heads/split*
        refs/heads/master
        refs/heads/testbr1
        refs/heads/parametrized
        refs/heads/parametrized4
    """.trimIndent()
    authMethod = uploadedKey {
        uploadedKey = "rsaopenssh"
        passphrase = "credentialsJSON:c6ac2c5c-1b3d-44c0-bd98-04d75dda453a"
    }
})


object HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup : Project({
    name = "https://github.com/ChubatovaTiger/ChubatovaGradleTestsBackup"

    vcsRoot(HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup_HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup)

    buildType(HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup_Splitgradle_4)

    cleanup {
        baseRule {
            all(builds = 2)
        }
    }
})

object HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup_Splitgradle_4 : BuildType({
    id("HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup_Splitgradle")
    name = "splitgradle"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        gradle {
            tasks = "clean build"
            gradleWrapperPath = ""
        }
    }

    features {
        feature {
            type = "splitTests"
            param("numberOfParts", "3")
        }
    }
})

object HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup_HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup : GitVcsRoot({
    name = "https://github.com/ChubatovaTiger/ChubatovaGradleTestsBackup"
    url = "https://github.com/ChubatovaTiger/ChubatovaGradleTestsBackup"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "ChubatovaTiger"
        password = "credentialsJSON:d55ac7e1-70e9-43d5-a101-541aef084a29"
    }
})
