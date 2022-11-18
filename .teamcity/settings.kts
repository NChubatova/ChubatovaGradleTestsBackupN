

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

    buildType(Publisher)
    buildType(IntegrationTest)
    buildType(UmsStudio)
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

}



object IntegrationTest : BuildType({

    id("IntegrationTest")
    name = "IntegrationTest"
)}

object UmsStudio : BuildType({

    id("UmsStudio")
    name = "UmsStudio"
)}

object DataProviderTests : BuildType({

    id("DataProviderTests")
    name = "DataProviderTests"
)}
object Geutebrueck : BuildType({

    id("Geutebrueck")
    name = "Geutebrueck"
)}
object ReSigner : BuildType({

    id("ReSigner")
    name = "ReSigner"
)}
object SetupConfigurationStudio : BuildType({

    id("SetupConfigurationStudio")
    name = "SetupConfigurationStudio"
)}
object SetupJournalReportingTool2 : BuildType({

    id("SetupJournalReportingTool2")
    name = "SetupJournalReportingTool2"
)}
object SetupNetagent : BuildType({

    id("SetupNetagent")
    name = "SetupNetagent"
)}
object LookAndFeel : BuildType({

    id("LookAndFeel")
    name = "LookAndFeel"
)}
object NativeUms : BuildType({

    id("NativeUms")
    name = "NativeUms"
)}
object Opc : BuildType({

    id("Opc")
    name = "Opc"
)}
 object PingHost : BuildType({

    id("PingHost")
    name = "PingHost"
)}
object Interflex : BuildType({

    id("Interflex")
    name = "Interflex"
)}
object SecuriLink_Current_UmsCurrentDeveloper_Subsystems_Ips : BuildType({

    id("SecuriLink_Current_UmsCurrentDeveloper_Subsystems_Ips")
    name = "SecuriLink_Current_UmsCurrentDeveloper_Subsystems_Ips"
)}
object SymbolBibliotheken : BuildType({

    id("SymbolBibliotheken")
    name = "SymbolBibliotheken"
)}
object Utilities : BuildType({

    id("Utilities")
    name = "Utilities"
)}
                    

triggers {
    schedule {
        id = "TRIGGER_665"
        schedulingPolicy = daily {
            hour = 17
        }
        branchFilter = "+:<default>"
        triggerBuild = always()
        withPendingChangesOnly = false
        param("cronExpression_min", "/2")

        enforceCleanCheckout = true
        enforceCleanCheckoutForDependencies = true
        buildParams {
            param("rebuildDependencies", "force")
        }
    }
    vcs {
        id = "vcsTrigger"
        quietPeriodMode = VcsTrigger.QuietPeriodMode.USE_DEFAULT
        triggerRules = "-:project-base/**/*"
        watchChangesInDependencies = true
    }
}

    dependencies {
        dependency(IntegrationTest) {
            snapshot {
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_10548"
                cleanDestination = true
                artifactRules = "**/*=>External-Artifacts/output/TeamCity-Artifacts/Studio/Integrationstests"
            }
        }
        dependency(UmsStudio) {
            snapshot {
                onDependencyFailure = FailureAction.FAIL_TO_START
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_9198"
                cleanDestination = true
                artifactRules = "**/*=>External-Artifacts/output/TeamCity-Artifacts/ConfigurationStudio"
            }
        }
        dependency(DataProviderTests) {
            snapshot {
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_10186"
                cleanDestination = true
                artifactRules = "**/*=>External-Artifacts/output/TeamCity-Artifacts/DataProvider-Tests"
            }
        }
        dependency(Geutebrueck) {
            snapshot {
                onDependencyFailure = FailureAction.FAIL_TO_START
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_10424"
                cleanDestination = true
                artifactRules = "**/*=>External-Artifacts/output/TeamCity-Artifacts/Geutebrueck"
            }
        }
        dependency(ReSigner) {
            snapshot {
                onDependencyFailure = FailureAction.FAIL_TO_START
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_9210"
                cleanDestination = true
                artifactRules = "**/*=>External-Artifacts/output/TeamCity-Artifacts/Installer/ReSigner"
            }
        }
        dependency(SetupConfigurationStudio) {
            snapshot {
                onDependencyFailure = FailureAction.FAIL_TO_START
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_9205"
                cleanDestination = true
                artifactRules = "**/*=>External-Artifacts/output/TeamCity-Artifacts/Installer/Setup-ConfigurationStudio"
            }
        }
        dependency(SetupJournalReportingTool2) {
            snapshot {
                onDependencyFailure = FailureAction.FAIL_TO_START
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_10174"
                cleanDestination = true
                artifactRules = "**/*=>External-Artifacts/output/TeamCity-Artifacts/Installer/Setup-JournalReportingTool2"
            }
        }
        dependency(SetupNetagent) {
            snapshot {
                onDependencyFailure = FailureAction.FAIL_TO_START
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_9207"
                cleanDestination = true
                artifactRules = "**/*=>External-Artifacts/output/TeamCity-Artifacts/Installer/Setup-Netagent"
            }
        }
        dependency(LookAndFeel) {
            snapshot {
                onDependencyFailure = FailureAction.FAIL_TO_START
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_249"
                cleanDestination = true
                artifactRules = "lib/svgviewer.zip=>External-Artifacts/output/TeamCity-Artifacts/LookAndFeel"
            }
        }
        dependency(NativeUms) {
            snapshot {
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_10641"
                cleanDestination = true
                artifactRules = "**/*=>External-Artifacts/output/TeamCity-Artifacts/NativeWin"
            }
        }
        dependency(Opc) {
            snapshot {
                onDependencyFailure = FailureAction.FAIL_TO_START
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_9200"
                cleanDestination = true
                artifactRules = "**/*=>External-Artifacts/output/TeamCity-Artifacts/OPC"
            }
        }
        dependency(PingHost) {
            snapshot {
                onDependencyFailure = FailureAction.FAIL_TO_START
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_10196"
                cleanDestination = true
                artifactRules = "**/*=>External-Artifacts/output/TeamCity-Artifacts/PingHost"
            }
        }
        dependency(Interflex) {
            snapshot {
                onDependencyFailure = FailureAction.FAIL_TO_START
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_10426"
                cleanDestination = true
                artifactRules = "**/*=>External-Artifacts/output/TeamCity-Artifacts/Subsystems/Interflex"
            }
        }
        dependency(SecuriLink_Current_UmsCurrentDeveloper_Subsystems_Ips) {
            snapshot {
                onDependencyFailure = FailureAction.FAIL_TO_START
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_10425"
                cleanDestination = true
                artifactRules = "**/*=>External-Artifacts/output/TeamCity-Artifacts/Subsystems/IPS"
            }
        }
        dependency(SymbolBibliotheken) {
            snapshot {
                onDependencyFailure = FailureAction.FAIL_TO_START
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_9201"
                cleanDestination = true
                artifactRules = "**/*=>External-Artifacts/output/TeamCity-Artifacts/SymbolBibliotheken"
            }
        }
        dependency(Utilities) {
            snapshot {
                onDependencyFailure = FailureAction.FAIL_TO_START
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_9202"
                cleanDestination = true
                artifactRules = "**/*=>External-Artifacts/output/TeamCity-Artifacts/Utilities"
            }
        }
    }
})
