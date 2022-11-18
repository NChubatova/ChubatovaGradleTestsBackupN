

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.smbUpload
import jetbrains.buildServer.configs.kotlin.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.triggers.schedule
import jetbrains.buildServer.configs.kotlin.triggers.vcs

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

    //buildType(Publisher)
    buildType(IntegrationTest)
    /*buildType(UmsStudio)
    buildType(DataProviderTests)
    buildType(Geutebrueck)
    buildType(ReSigner)
    buildType(SetupConfigurationStudio)
    buildType(SetupJournalReportingTool2)
    buildType(SetupNetagent)
    buildType(LookAndFeel)
    buildType(NativeUms)
    buildType(Opc)
    buildType(PingHost)
    buildType(Interflex)
    buildType(SecuriLink_Current_UmsCurrentDeveloper_Subsystems_Ips)
    buildType(SymbolBibliotheken)
    buildType(Utilities)
    */

}



object IntegrationTest : BuildType({

)}


