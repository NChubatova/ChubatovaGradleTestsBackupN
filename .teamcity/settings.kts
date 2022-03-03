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
    vcsRoot(Gradletests)
    vcsRoot(HttpsGithubComChubatovaTigerChubatovaGradleTestsBackupRefsHeadsMaster1)
    vcsRoot(Gradletests11)
    vcsRoot(Gradletests1)

    buildType(Buildsplit_4)
    buildType(Dependent)

    subProject(id)
}

object Buildsplit_4 : BuildType({
    id("Buildsplit")
    name = "buildsplit"

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
            param("numberOfParts", "4")
        }
    }

    requirements {
        doesNotContain("teamcity.agent.name", "tc-ubuntu-server-18-1")
    }

    cleanup {
        keepRule {
            id = "KEEP_RULE_6"
            keepAtLeast = builds(3)
            applyToBuilds {
                withStatus = successful()
            }
            dataToKeep = everything()
            preserveArtifactsDependencies = true
        }
        baseRule {
            option("disableCleanupPolicies", true)
        }
    }
})

object Dependent : BuildType({
    name = "dependent2"

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

object Gradletests : GitVcsRoot({
    name = "gradletests"
    url = "https://github.com/ChubatovaTiger/ChubatovaGradleTestsBackup"
    branch = "refs/heads/master"
})

object Gradletests1 : GitVcsRoot({
    name = "gradletests (1)"
    url = "https://github.com/ChubatovaTiger/ChubatovaGradleTestsBackup"
    branch = "refs/heads/split"
})

object Gradletests11 : GitVcsRoot({
    name = "gradletests (1) (1)"
    url = "https://github.com/ChubatovaTiger/ChubatovaGradleTestsBackup"
    branch = "refs/heads/split"
    branchSpec = "+:refs/heads/parametrized"
})

object HttpsGithubComChubatovaTigerChubatovaGradleTestsBackupRefsHeadsMaster1 : GitVcsRoot({
    name = "https://github.com/ChubatovaTiger/ChubatovaGradleTestsBackup#refs/heads/master (1)"
    url = "https://github.com/ChubatovaTiger/ChubatovaGradleTestsBackup"
    branch = "refs/heads/split"
    branchSpec = """
        refs/heads/split*
        refs/heads/master
        refs/heads/testbr1
        refs/heads/parametrized
        refs/heads/parametrized3
    """.trimIndent()
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


object id : Project({
    name = "чсбьб"

    buildType(id_id)
})

object id_id : BuildType({
    name = "ыва"
})
