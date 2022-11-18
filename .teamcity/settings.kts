import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.smbUpload
import jetbrains.buildServer.configs.kotlin.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.triggers.schedule
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.buildSteps.script


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
name = "IntegrationTest" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})

object UmsStudio : BuildType({
name = "UmsStudio" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})

object DataProviderTests : BuildType({

    id("DataProviderTests")
    name = "DataProviderTests" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})
object Geutebrueck : BuildType({

    id("Geutebrueck")
    name = "Geutebrueck" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})
object ReSigner : BuildType({

    id("ReSigner")
    name = "ReSigner" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})
object SetupConfigurationStudio : BuildType({

    id("SetupConfigurationStudio")
    name = "SetupConfigurationStudio" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})
object SetupJournalReportingTool2 : BuildType({

    id("SetupJournalReportingTool2")
    name = "SetupJournalReportingTool2" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})
object SetupNetagent : BuildType({

    id("SetupNetagent")
    name = "SetupNetagent" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})
object LookAndFeel : BuildType({

    id("LookAndFeel")
    name = "LookAndFeel" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})
object NativeUms : BuildType({

    id("NativeUms")
    name = "NativeUms" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})
object Opc : BuildType({

    id("Opc")
    name = "Opc" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})
 object PingHost : BuildType({

    id("PingHost")
    name = "PingHost" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})
object Interflex : BuildType({

    id("Interflex")
    name = "Interflex" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})
object SecuriLink_Current_UmsCurrentDeveloper_Subsystems_Ips : BuildType({

    id("SecuriLink_Current_UmsCurrentDeveloper_Subsystems_Ips")
    name = "SecuriLink_Current_UmsCurrentDeveloper_Subsystems_Ips" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})
object SymbolBibliotheken : BuildType({

    id("SymbolBibliotheken")
    name = "SymbolBibliotheken" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})
object Utilities : BuildType({

    id("Utilities")
    name = "Utilities" 
     artifactRules = "a.txt => ."

    steps {
        script {
            scriptContent = "echo a > a.txt"
        }
    }
})
                    
object Publisher : BuildType({
   name = "Publisher" 
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


