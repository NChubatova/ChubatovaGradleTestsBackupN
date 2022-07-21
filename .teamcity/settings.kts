import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.projectFeatures.activeStorage
import jetbrains.buildServer.configs.kotlin.projectFeatures.s3Storage

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

    buildType(As)

    features {
        s3Storage {
            id = "PROJECT_EXT_6"
            bucketName = "chubatovatransferacceleration"
            forceVirtualHostAddressing = true
            awsEnvironment = default {
                awsRegionName = "eu-central-1"
            }
            accessKeyID = "AKIA5JH2VERVHVMPJQJI"
            accessKey = "credentialsJSON:4f0dd7f7-9e59-443b-8487-fc73ea89b097"
            param("storage.s3.accelerateModeEnabled", "true")
        }
        activeStorage {
            id = "PROJECT_EXT_7"
            activeStorageID = "PROJECT_EXT_6"
        }
    }
}

object As : BuildType({
    name = "as"

    artifactRules = "+:bc.txt => ."

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            scriptContent = "echo b > bc.txt"
        }
    }
})
