import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.CustomChart
import jetbrains.buildServer.configs.kotlin.CustomChart.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.freeDiskSpace
import jetbrains.buildServer.configs.kotlin.buildTypeCustomChart
import jetbrains.buildServer.configs.kotlin.projectCustomChart
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

version = "2023.05"

project {

    vcsRoot(HttpsGithubComChubatovaTigerVsSubp)

    buildType(Aa)
    buildType(Fr)

    features {
        projectCustomChart {
            id = "PROJECT_EXT_5"
            title = "fds"
            seriesTitle = "Serie"
            format = CustomChart.Format.DURATION
            series = listOf(
                Serie(title = "Free Disk Space Cleanup Time", key = SeriesKey("buildStageDuration:freeDiskSpaceRequirement"), sourceBuildTypeId = "FreeDiskSpace_Fr")
            )
        }
        buildTypeCustomChart {
            id = "PROJECT_EXT_6"
            title = "fdsp_build"
            seriesTitle = "Serie"
            format = CustomChart.Format.DURATION
            series = listOf(
                Serie(title = "Free Disk Space Cleanup Time", key = SeriesKey("buildStageDuration:freeDiskSpaceRequirement"))
            )
        }
    }
}

object Aa : BuildType({
    name = "aa"

    vcs {
        root(DslContext.settingsRoot)
        root(HttpsGithubComChubatovaTigerVsSubp)
    }
})

object Fr : BuildType({
    name = "fr"

    features {
        freeDiskSpace {
            requiredSpace = "300mb"
            failBuild = false
        }
    }
})

object HttpsGithubComChubatovaTigerVsSubp : GitVcsRoot({
    name = "https://github.com/ChubatovaTiger/vs_subp"
    url = "https://github.com/ChubatovaTiger/vs_subp"
    branch = "${DslContext.getParameter("branchName")}"
    authMethod = password {
        userName = "ChubatovaTiger"
        password = "credentialsJSON:a3b296c3-ed89-4c8e-ae53-9d525c32691d"
    }
})
