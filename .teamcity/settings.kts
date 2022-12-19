import jetbrains.buildServer.configs.kotlin.*
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

version = "2022.10"

project {

    buildType(Build1)

    subProject(Project2)
}

object Build1 : BuildType({
    name = "build1"
})


object Project2 : Project({
    name = "project2"

    vcsRoot(Project2_HttpsGithubComChubatovaTigerVsMrPr2)

    buildType(Build2)
})

object Build2 : BuildType({
    name = "build2"
})

object Project2_HttpsGithubComChubatovaTigerVsMrPr2 : GitVcsRoot({
    name = "https://github.com/ChubatovaTiger/vsMrPr2"
    url = "https://github.com/ChubatovaTiger/vsMrPr2"
    branch = "refs/heads/main"
    authMethod = password {
        userName = "ChubatovaTiger"
        password = "credentialsJSON:96e0afaf-d27d-465e-9f33-7d8408c47b6c"
    }
})
