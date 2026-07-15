package app.template.patches.projectivy

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.template.patches.shared.Constants.PROJECTIVY_COMPATIBILITY
import app.template.patches.shared.clearBody

@Suppress("unused")
val projectivyUnlockPremiumPatch = bytecodePatch(
    name = "Unlock Premium",
    description = "Unlocks all premium features by bypassing the native library premium check.",
    default = true,
) {
    compatibleWith(PROJECTIVY_COMPATIBILITY)

    execute {
        PremiumCheckFingerprint.method.apply {
            clearBody()
            addInstructions(0, "const/4 v0, 0x1\nreturn v0")
        }
    }
}
