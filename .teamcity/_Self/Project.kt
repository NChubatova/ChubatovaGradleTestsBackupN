package _Self

import _Self.buildTypes.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.amazonEC2CloudImage
import jetbrains.buildServer.configs.kotlin.amazonEC2CloudProfile

object Project : Project({

    buildType(Build2)
    buildType(Build1)

    template(Tmpl)

    features {
        amazonEC2CloudImage {
            id = "PROJECT_EXT_2"
            profileId = "amazon-1"
            agentPoolId = "-2"
            vpcSubnetId = "subnet-043178c302cabfe37"
            keyPairName = "chubatova-amazon-ireland"
            instanceType = "t3.medium"
            securityGroups = listOf("sg-072d8bfa0626ea2a6")
            source = Source("ami-0b55e6eb21b887f36")
        }
        amazonEC2CloudProfile {
            id = "amazon-1"
            name = "a"
            terminateIdleMinutes = 0
            region = AmazonEC2CloudProfile.Regions.EU_WEST_DUBLIN
            authType = instanceIAMRole()
            param("secure:access-id", "credentialsJSON:f67de2dd-6349-4a0a-8a7a-b99d61bf6447")
            param("secure:secret-key", "credentialsJSON:f67de2dd-6349-4a0a-8a7a-b99d61bf6447")
        }
    }
})
