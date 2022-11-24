import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.amazonEC2CloudImage
import jetbrains.buildServer.configs.kotlin.amazonEC2CloudProfile
import jetbrains.buildServer.configs.kotlin.buildSteps.script

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

    buildType(Cmd)

    features {
        amazonEC2CloudImage {
            id = "PROJECT_EXT_5"
            profileId = "amazon-1"
            agentPoolId = "-2"
            source = LaunchTemplate(templateId = "lt-0b5689014f6b6ca22", version = AmazonEC2CloudImage.DEFAULT_VERSION)
        }
        amazonEC2CloudProfile {
            id = "amazon-1"
            name = "ec2"
            terminateIdleMinutes = 30
            region = AmazonEC2CloudProfile.Regions.EU_WEST_DUBLIN
            maxInstancesCount = 3
            authType = accessKey {
                keyId = "credentialsJSON:0105dcd1-c6cc-45f5-819d-3b631d1306d1"
                secretKey = "credentialsJSON:a050fd09-7abe-4064-96cf-7e6ff90f9671"
            }
        }
    }
}

object Cmd : BuildType({
    name = "cmd"

    steps {
        script {
            scriptContent = "ls ~"
        }
    }
})
