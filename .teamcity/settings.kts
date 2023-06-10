import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.amazonEC2CloudImage
import jetbrains.buildServer.configs.kotlin.amazonEC2CloudProfile

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

version = "2023.05"

project {

    features {
        amazonEC2CloudImage {
            id = "PROJECT_EXT_4"
            profileId = "amazon-1"
            agentPoolId = "1"
            name = "im2"
            instanceType = "t2.micro"
            securityGroups = listOf("sg-098887b6daeb441ce")
            useSpotInstances = true
            spotInstanceBidPrice = 1.0
            source = Source("ami-0b9308ec4c1afd22f")
        }
        amazonEC2CloudProfile {
            id = "amazon-1"
            name = "aws"
            terminateIdleMinutes = 30
            region = AmazonEC2CloudProfile.Regions.EU_WEST_LONDON
            authType = accessKey {
                keyId = "credentialsJSON:09b97b83-9b56-4d9a-8c5d-ec9a8912f422"
                secretKey = "credentialsJSON:54b81fa7-f4fa-4743-a9b9-6a9a0b5cd1bb"
            }
        }
    }
}
