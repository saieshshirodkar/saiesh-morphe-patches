package app.template.patches.at4k

import app.morphe.patcher.Fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

val ContentProviderOnCreateFingerprint = Fingerprint(
    definingClass = "Lcom/pairip/licensecheck/LicenseContentProvider;",
    name = "onCreate",
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC),
)

val LicenseCheckFingerprint = Fingerprint(
    definingClass = "Lcom/pairip/licensecheck/LicenseClient;",
    name = "checkLicense",
    returnType = "V",
    parameters = listOf("Landroid/content/Context;"),
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    strings = listOf("Skipping license check in isolated process."),
)

val InitializeLicenseCheckFingerprint = Fingerprint(
    definingClass = "Lcom/pairip/licensecheck/LicenseClient;",
    name = "initializeLicenseCheck",
    returnType = "V",
    accessFlags = listOf(AccessFlags.PUBLIC),
)

val PerformLocalInstallerCheckFingerprint = Fingerprint(
    definingClass = "Lcom/pairip/licensecheck/LicenseClient;",
    name = "performLocalInstallerCheck",
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PRIVATE),
    strings = listOf("com.android.vending"),
)

val LicenseExitActionFingerprint = Fingerprint(
    definingClass = "Lcom/pairip/licensecheck/LicenseClient$1;",
    name = "run",
    returnType = "V",
)

val LicenseActivityExitAppFingerprint = Fingerprint(
    definingClass = "Lcom/pairip/licensecheck/LicenseActivity;",
    name = "exitApp",
    returnType = "V",
    accessFlags = listOf(AccessFlags.PROTECTED),
)

val LicenseActivityCloseAllTasksFingerprint = Fingerprint(
    definingClass = "Lcom/pairip/licensecheck/LicenseActivity;",
    name = "closeAllTasks",
    returnType = "V",
)

val ErrorDialogActivityFingerprint = Fingerprint(
    definingClass = "Lcom/pairip/licensecheck/LicenseClient;",
    name = "startErrorDialogActivity",
    returnType = "V",
    accessFlags = listOf(AccessFlags.PRIVATE),
    strings = listOf("activitytype"),
)

val PaywallActivityFingerprint = Fingerprint(
    definingClass = "Lcom/pairip/licensecheck/LicenseClient;",
    name = "startPaywallActivity",
    returnType = "V",
    parameters = listOf("Landroid/app/PendingIntent;"),
    accessFlags = listOf(AccessFlags.PRIVATE),
    strings = listOf("paywallintent"),
)

val PremiumStateSetterFingerprint = Fingerprint(
    definingClass = "LQ3/A5;",
    name = "h",
    returnType = "V",
    parameters = listOf("Z"),
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    strings = listOf("launcher_prefs", "is_premium", "Premium status updated to "),
)

val PurchaseValidatorFingerprint = Fingerprint(
    definingClass = "LQ3/A5;",
    name = "e",
    returnType = "V",
    parameters = listOf("Ljava/util/List;"),
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    strings = listOf("premium", "purchaseState", "acknowledged"),
)
