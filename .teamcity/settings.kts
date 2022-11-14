import jetbrains.buildServer.configs.kotlin.*

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

    subProject(id2018r2)
    subProject(id2019r1)
    subProject(id2019r2)
    subProject(id2019r3)
}


object id2018r2 : Project({
    id("2018r2")
    name = "2018R2"

    subProject(id2018r2_Release)
    subProject(id2018r2_Weekly)
    subProject(id2018r2_Nightly)
})


object id2018r2_Nightly : Project({
    id("2018r2_Nightly")
    name = "nightly"
})


object id2018r2_Release : Project({
    id("2018r2_Release")
    name = "release"
})


object id2018r2_Weekly : Project({
    id("2018r2_Weekly")
    name = "weekly"
})


object id2019r1 : Project({
    id("2019r1")
    name = "2019R1"

    subProject(id2019r1_Release)
    subProject(id2019r1_Nightly)
    subProject(id2019r1_Weekly)
})


object id2019r1_Nightly : Project({
    id("2019r1_Nightly")
    name = "nightly"
})


object id2019r1_Release : Project({
    id("2019r1_Release")
    name = "release"
})


object id2019r1_Weekly : Project({
    id("2019r1_Weekly")
    name = "weekly"
})


object id2019r2 : Project({
    id("2019r2")
    name = "2019R2"

    subProject(id2019r2_Release)
    subProject(id2019r2_Nightly)
    subProject(id2019r2_Weekly)
})


object id2019r2_Nightly : Project({
    id("2019r2_Nightly")
    name = "nightly"
})


object id2019r2_Release : Project({
    id("2019r2_Release")
    name = "release"
})


object id2019r2_Weekly : Project({
    id("2019r2_Weekly")
    name = "weekly"
})


object id2019r3 : Project({
    id("2019r3")
    name = "2019R3"

    subProject(id2019r3_Nightly)
    subProject(id2019r3_Weekly)
})


object id2019r3_Nightly : Project({
    id("2019r3_Nightly")
    name = "nightly"
})


object id2019r3_Weekly : Project({
    id("2019r3_Weekly")
    name = "weekly"
})
