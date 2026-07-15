package app.template.patches.iss

import app.morphe.patcher.Fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

val IssPremiumCheckFingerprint = Fingerprint(
    definingClass = "Lsk2;",
    name = "T",
    returnType = "Z",
    parameters = listOf("Landroid/content/Context;"),
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    strings = listOf("pro_version"),
)
