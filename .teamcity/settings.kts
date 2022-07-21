import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.projectFeatures.activeStorage
import jetbrains.buildServer.configs.kotlin.projectFeatures.s3Storage



version = "2022.04"

project {

    buildType(Arts)

    features {
        s3Storage {
            id = "PROJECT_EXT_4"
            bucketName = "chubatovatransferacceleration"
            accessKey = "credentialsJSON:1452225c-83d9-4a40-9171-f7f9e4ab9a5c"
            awsEnvironment = custom {
                endpoint = "https://chubatovatransferacceleration.s3-accelerate.amazonaws.com/"
                awsRegionName = "eu-central-1"
            }
            accessKeyID = "mykey"
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
