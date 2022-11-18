import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.smbUpload
import jetbrains.buildServer.configs.kotlin.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.triggers.schedule
import jetbrains.buildServer.configs.kotlin.triggers.vcs



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


