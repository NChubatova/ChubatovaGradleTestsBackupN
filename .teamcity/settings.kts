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

    buildType(Arts)

    features {
        s3Storage {
            id = "PROJECT_EXT_4"
            bucketName = "chubatovatransferacceleration"
            cloudFrontUploadDistribution = "E2U2DKS2LRAIBE"
            cloudFrontDownloadDistribution = "E3JAYS17K6912V"
            cloudFrontPublicKeyId = "KBNZ121WB9BZ0"
            cloudFrontPrivateKey = "credentialsJSON:e95855b4-3d61-4379-a908-84dcc13dc66a"
            accessKey = "credentialsJSON:1452225c-83d9-4a40-9171-f7f9e4ab9a5c"
            awsEnvironment = custom {
                endpoint = "https://s3.eu-central-1.amazonaws.com"
                awsRegionName = "eu-central-1"
            }
            accessKeyID = "AKIA5JH2VERVHVMPJQJI"
        }
        activeStorage {
            id = "PROJECT_EXT_5"
            activeStorageID = "PROJECT_EXT_4"
        }
    }
}

object Arts : BuildType({
    name = "arts"

    artifactRules = "*.txt => s3arts"

    steps {
        script {
            scriptContent = "echo a > %build.number%.txt"
        }
    }
})
