package app.template.patches.iss

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.template.patches.shared.Constants.ISS_COMPATIBILITY
import app.template.patches.shared.clearBody

@Suppress("unused")
val issUnlockPremiumPatch = bytecodePatch(
    name = "Unlock Premium",
    description = "Unlocks all premium features by forcing the pro_version SharedPreferences check to always return true.",
    default = true,
) {
    compatibleWith(ISS_COMPATIBILITY)

    execute {
        IssPremiumCheckFingerprint.method.apply {
            clearBody()
            addInstructions(0, "const/4 v0, 0x1\nreturn v0")
        }
    }
}
