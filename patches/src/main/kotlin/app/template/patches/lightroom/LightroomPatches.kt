package app.template.patches.lightroom

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.template.patches.shared.Constants.LIGHTROOM_COMPATIBILITY
import app.template.patches.shared.clearBody

@Suppress("unused")
val lightroomDisablePairipPatch = bytecodePatch(
    name = "Disable PairIP DRM",
    description = "Disables PairIP signature verification, Google Play LVL license check, System.exit kill switch, checksum integrity verification, and MHSDK analytics. Required for the app to launch after re-signing.",
    default = true,
) {
    compatibleWith(LIGHTROOM_COMPATIBILITY)

    execute {
        VMRunnerInvokeFingerprint.method.apply {
            clearBody()
            addInstructions(0, "const/4 v0, 0x0\nreturn-object v0")
        }

        SubscriptionStateFingerprint.method.apply {
            clearBody()
            addInstructions(0, "sget-object v0, Lcom/adobe/lrmobile/thfoundation/library/n2${'$'}c;->Subscription:Lcom/adobe/lrmobile/thfoundation/library/n2${'$'}c;\nreturn-object v0")
        }

        ForceStopRunnableFingerprint.method.apply {
            clearBody()
            addInstructions(0, "return-void")
        }

        FirebaseInitFingerprint.method.apply {
            clearBody()
            addInstructions(0, "const/4 v0, 0x1\nreturn v0")
        }

        LoginCheckFingerprint.method.apply {
            clearBody()
            addInstructions(0, "const/4 v0, 0x1\nreturn v0")
        }

        ForceUpgradeCheckFingerprint.method.apply {
            clearBody()
            addInstructions(0, "const/4 v0, 0x0\nreturn v0")
        }

        VerifyIntegrityFingerprint.method.apply {
            clearBody()
            addInstructions(0, "return-void")
        }

        VerifySignatureMatchesFingerprint.method.apply {
            clearBody()
            addInstructions(0, "const/4 v0, 0x1\nreturn v0")
        }

        CheckLicenseFingerprint.method.apply {
            clearBody()
            addInstructions(0, "return-void")
        }

        PerformLocalInstallerCheckFingerprint.method.apply {
            clearBody()
            addInstructions(0, "const/4 v0, 0x1\nreturn v0")
        }

        LicenseExitActionFingerprint.methodOrNull?.apply {
            clearBody()
            addInstructions(0, "return-void")
        }

        LicenseActivityExitAppFingerprint.methodOrNull?.apply {
            clearBody()
            addInstructions(0, "return-void")
        }

        ChecksumVerifierC_Fingerprint.methodOrNull?.apply {
            clearBody()
            addInstructions(0, "return-void")
        }

        MHSDKInitFingerprint.methodOrNull?.apply {
            clearBody()
            addInstructions(0, "return-void")
        }

        LrMobileAppExitEFingerprint.methodOrNull?.apply {
            clearBody()
            addInstructions(0, "return-void")
        }

        LrMobileAppExitFFingerprint.methodOrNull?.apply {
            clearBody()
            addInstructions(0, "return-void")
        }

        WichitaCoreB_Fingerprint.methodOrNull?.apply {
            clearBody()
            addInstructions(0, "return-void")
        }
    }
}

@Suppress("unused")
val lightroomUnlockPremiumPatch = bytecodePatch(
    name = "Unlock Premium",
    description = "Unlocks all premium features by forcing entitlement status to SUBSCRIPTION and making all premium gating checks return true.",
    default = true,
) {
    compatibleWith(LIGHTROOM_COMPATIBILITY)

    execute {
        LoupePremiumModeFingerprint.method.apply {
            clearBody()
            addInstructions(0, "const/4 v0, 0x1\nreturn v0")
        }

        EditPremiumModeFingerprint.method.apply {
            clearBody()
            addInstructions(0, "const/4 v0, 0x1\nreturn v0")
        }

        TrialExpiredFingerprint.method.apply {
            clearBody()
            addInstructions(0, "const/4 v0, 0x0\nreturn v0")
        }

        EntitlementParserFingerprint.method.apply {
            clearBody()
            addInstructions(0, "sget-object v0, Lmu/a${'$'}a;->SUBSCRIPTION:Lmu/a${'$'}a;\nreturn-object v0")
        }
    }
}
