package app.template.patches.projectivy

import app.morphe.patcher.Fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

val PremiumCheckFingerprint = Fingerprint(
    definingClass = "Lcom/spocky/projengmenu/PTApplication;",
    name = "e",
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
)
