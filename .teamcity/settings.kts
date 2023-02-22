import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.buildCache
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.projectFeatures.activeStorage
import jetbrains.buildServer.configs.kotlin.projectFeatures.buildReportTab
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

version = "2022.10"

project {
    description = "Contains all other projects"

    params {
        param("teamcity.internal.feature.build.cache.enabled", "true")
    }

    features {
        buildReportTab {
            id = "PROJECT_EXT_1"
            title = "Code Coverage"
            startPage = "coverage.zip!index.html"
        }
        s3Storage {
            id = "PROJECT_EXT_3"
            bucketName = "n.chubatova-test"
            bucketPrefix = "chuCaches"
            awsEnvironment = default {
                awsRegionName = "eu-central-1"
            }
            accessKeyID = "AKIA5JH2VERVHVMPJQJI"
            accessKey = "credentialsJSON:eabd0246-b954-4671-a8c6-94088e24abc4"
        }
        activeStorage {
            id = "PROJECT_EXT_4"
            activeStorageID = "PROJECT_EXT_3"
        }
    }

    cleanup {
        baseRule {
            preventDependencyCleanup = false
        }
    }

    subProject(Project2)
    subProject(Project1)
}


object Project1 : Project({
    name = "project1"

    buildType(Project1_B2pr1cons)
    buildType(Project1_B1pr1)

    subProject(Project1_Project11)
})

object Project1_B1pr1 : BuildType({
    name = "b1pr1"

    params {
        param("dirNum", "1")
    }

    vcs {
        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = """
                mkdir dir1-%dirNum%
                echo a > dir1-%dirNum%/2
            """.trimIndent()
        }
    }

    features {
        buildCache {
            name = "mycache2"
            rules = "dir-%dirNum%"
        }
    }
})

object Project1_B2pr1cons : BuildType({
    name = "b2pr1cons"

    vcs {
        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = "ls"
        }
    }

    features {
        buildCache {
            name = "mycache2"
            publish = false
        }
    }
})


object Project1_Project11 : Project({
    name = "project11"

    buildType(Project1_Project11_Cons)
    buildType(Project1_Project11_B11p11)
})

object Project1_Project11_B11p11 : BuildType({
    name = "b11p11"

    steps {
        script {
            scriptContent = "echo a > 111-%build.counter%"
        }
    }

    features {
        buildCache {
            name = "mycache3"
            use = false
            publishOnlyChanged = false
            rules = "111-%build.counter%"
        }
    }
})

object Project1_Project11_Cons : BuildType({
    name = "cons"

    steps {
        script {
            scriptContent = "ls"
        }
    }

    features {
        buildCache {
            name = "mycache2"
            publish = false
        }
    }
})


object Project2 : Project({
    name = "project2"

    buildType(Project2_B2p2cons)
    buildType(Project2_B1p2)
})

object Project2_B1p2 : BuildType({
    name = "b1p2"

    steps {
        script {
            scriptContent = "echo a > 2-%build.counter%"
        }
    }

    features {
        buildCache {
            name = "mycache"
            use = false
            publishOnlyChanged = false
            rules = "2-%build.counter%"
        }
    }
})

object Project2_B2p2cons : BuildType({
    name = "b2p2cons"

    steps {
        script {
            scriptContent = "ls"
        }
    }

    features {
        buildCache {
            name = "mycache"
            publish = false
        }
    }
})
