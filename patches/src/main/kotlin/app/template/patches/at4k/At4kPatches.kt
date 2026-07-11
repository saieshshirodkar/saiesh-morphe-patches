package app.template.patches.at4k

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.template.patches.shared.Constants.AT4K_COMPATIBILITY
import app.template.patches.shared.clearBody
import app.template.patches.shared.ensureRegisters

@Suppress("unused")
val at4kDisablePairipPatch = bytecodePatch(
    name = "Disable PairIP DRM",
    description = "Disables PairIP signature verification and Google Play LVL license check. Required for the app to launch after re-signing.",
    default = true,
) {
    compatibleWith(AT4K_COMPATIBILITY)

    execute {
        ContentProviderOnCreateFingerprint.method.apply {
            clearBody()
            addInstructions(0, "const/4 v0, 0x1\nreturn v0")
        }

        LicenseCheckFingerprint.method.apply {
            clearBody()
            addInstructions(0, "return-void")
        }

        InitializeLicenseCheckFingerprint.method.apply {
            clearBody()
            addInstructions(0, "return-void")
        }

        LicenseExitActionFingerprint.method.apply {
            clearBody()
            addInstructions(0, "return-void")
        }

        LicenseActivityExitAppFingerprint.method.apply {
            clearBody()
            addInstructions(0, "return-void")
        }

        PerformLocalInstallerCheckFingerprint.methodOrNull?.apply {
            clearBody()
            addInstructions(0, "const/4 v0, 0x1\nreturn v0")
        }

        LicenseActivityCloseAllTasksFingerprint.methodOrNull?.apply {
            clearBody()
            addInstructions(0, "return-void")
        }

        ErrorDialogActivityFingerprint.methodOrNull?.apply {
            clearBody()
            addInstructions(0, "return-void")
        }

        PaywallActivityFingerprint.methodOrNull?.apply {
            clearBody()
            addInstructions(0, "return-void")
        }
    }
}

@Suppress("unused")
val at4kUnlockPremiumPatch = bytecodePatch(
    name = "Unlock Premium",
    description = "Unlocks all premium features by forcing the premium state to true in the purchase manager.",
    default = true,
) {
    compatibleWith(AT4K_COMPATIBILITY)

    execute {
        PremiumStateSetterFingerprint.method.apply {
            clearBody()
            ensureRegisters(3)
            addInstructions(0, """
                sget-object v0, LQ3/A5;->e:LM/h0;
                const/4 v1, 0x1
                invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
                move-result-object v1
                invoke-virtual {v0, v1}, LM/h0;->setValue(Ljava/lang/Object;)V
                sget-object v0, LQ3/A5;->b:Landroid/app/Application;
                const-string v1, "launcher_prefs"
                const/4 v2, 0x0
                invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;
                move-result-object v0
                invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences${'$'}Editor;
                move-result-object v0
                const-string v1, "is_premium"
                const/4 v2, 0x1
                invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences${'$'}Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences${'$'}Editor;
                move-result-object v0
                invoke-interface {v0}, Landroid/content/SharedPreferences${'$'}Editor;->apply()V
                return-void
            """.trimIndent())
        }

        PurchaseValidatorFingerprint.methodOrNull?.apply {
            clearBody()
            addInstructions(0, "const/4 v0, 0x1\ninvoke-static {v0}, LQ3/A5;->h(Z)V\nreturn-void")
        }
    }
}
