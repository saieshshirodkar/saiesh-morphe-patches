package app.template.patches.lightroom

import app.morphe.patcher.Fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

val VerifyIntegrityFingerprint = Fingerprint(
    definingClass = "Lcom/pairip/SignatureCheck;",
    name = "verifyIntegrity",
    returnType = "V",
    parameters = listOf("Landroid/content/Context;"),
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    strings = listOf("SHA-256", "SignatureCheck", "Signature check ok"),
)

val VerifySignatureMatchesFingerprint = Fingerprint(
    definingClass = "Lcom/pairip/SignatureCheck;",
    name = "verifySignatureMatches",
    returnType = "Z",
    parameters = listOf("Ljava/lang/String;"),
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
)

val CheckLicenseFingerprint = Fingerprint(
    definingClass = "Lcom/pairip/licensecheck/LicenseClient;",
    name = "checkLicense",
    returnType = "V",
    parameters = listOf("Landroid/content/Context;"),
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    strings = listOf("Skipping license check in isolated process."),
)

val SubscriptionStateFingerprint = Fingerprint(
    definingClass = "Lbg/b;",
    name = "c",
    returnType = "Lcom/adobe/lrmobile/thfoundation/library/n2${'$'}c;",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC, AccessFlags.FINAL),
)

val VMRunnerInvokeFingerprint = Fingerprint(
    definingClass = "Lcom/pairip/VMRunner;",
    name = "invoke",
    returnType = "Ljava/lang/Object;",
    parameters = listOf("Ljava/lang/String;", "[Ljava/lang/Object;"),
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    strings = listOf("Executing ", "Error while loading bytecode.", "VMRunner"),
)

val PerformLocalInstallerCheckFingerprint = Fingerprint(
    definingClass = "Lcom/pairip/licensecheck/LicenseClient;",
    name = "performLocalInstallerCheck",
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PRIVATE),
    strings = listOf("com.android.vending"),
)

val LoupePremiumModeFingerprint = Fingerprint(
    definingClass = "Lcom/adobe/lrmobile/material/loupe/l6;",
    name = "isPremiumMode",
    returnType = "Z",
)

val EditPremiumModeFingerprint = Fingerprint(
    definingClass = "Lcom/adobe/lrmobile/material/loupe/g6;",
    name = "isPremiumMode",
    returnType = "Z",
)

val TrialExpiredFingerprint = Fingerprint(
    definingClass = "Lcom/adobe/lrmobile/status/CloudyStatusIcon;",
    name = "isTrialExpired",
    returnType = "Z",
)

val LoginCheckFingerprint = Fingerprint(
    definingClass = "Lcom/adobe/lrmobile/application/login/LoginActivity;",
    name = "H2",
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
)

val ForceUpgradeCheckFingerprint = Fingerprint(
    definingClass = "Lpq/n;",
    name = "i",
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
)

val ForceStopRunnableFingerprint = Fingerprint(
    definingClass = "Landroidx/work/impl/utils/ForceStopRunnable;",
    name = "run",
    returnType = "V",
    accessFlags = listOf(AccessFlags.PUBLIC),
    strings = listOf("The file system on the device is in a bad state. WorkManager cannot access the app"),
)

val FirebaseInitFingerprint = Fingerprint(
    definingClass = "Lcom/google/firebase/provider/FirebaseInitProvider;",
    name = "onCreate",
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC),
)

val EntitlementParserFingerprint = Fingerprint(
    definingClass = "Lmu/a${'$'}a${'$'}a;",
    name = "a",
    returnType = "Lmu/a${'$'}a;",
    parameters = listOf("Ljava/lang/String;"),
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.FINAL),
    strings = listOf("SUBSCRIPTION", "NOT_ENTITLED", "EXPIRED", "TRIAL"),
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

val ChecksumVerifierC_Fingerprint = Fingerprint(
    definingClass = "Lcom/adobe/mobile/icmobilelib/ChecksumVerifier;",
    name = "c",
    returnType = "V",
    accessFlags = listOf(AccessFlags.PUBLIC),
    strings = listOf("MH", "ChecksumVerifier: preparing encrypted payload"),
)

val MHSDKInitFingerprint = Fingerprint(
    definingClass = "Lcom/adobe/lrmobile/LrMobileApplication;",
    name = "I",
    returnType = "V",
    parameters = listOf("Lma/s;"),
    accessFlags = listOf(AccessFlags.PRIVATE),
    strings = listOf("Initializing MHSDK", "icm_branch_campaign"),
)

val LrMobileAppExitEFingerprint = Fingerprint(
    definingClass = "Lcom/adobe/lrmobile/LrMobileApplication;",
    name = "e",
    returnType = "V",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC, AccessFlags.SYNTHETIC),
)

val LrMobileAppExitFFingerprint = Fingerprint(
    definingClass = "Lcom/adobe/lrmobile/LrMobileApplication;",
    name = "f",
    returnType = "V",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC, AccessFlags.SYNTHETIC),
)

val WichitaCoreB_Fingerprint = Fingerprint(
    definingClass = "Lcom/adobe/wichitafoundation/Core;",
    name = "b",
    returnType = "V",
    parameters = listOf("Ljava/io/File;"),
    accessFlags = listOf(AccessFlags.PRIVATE, AccessFlags.STATIC),
    strings = listOf("KSKeychainManager_Key", "KSKeychainManager_IV"),
)
