package app.template.patches.shared

import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

object Constants {
    // Lightroom — Photo & Video Editor by Adobe
    val LIGHTROOM_COMPATIBILITY = Compatibility(
        name = "Lightroom",
        packageName = "com.adobe.lrmobile",
        appIconColor = 0x31ADFF,
        targets = listOf(AppTarget(version = "11.4.4", versionCode = 711104400))
    )

    // AT4K Launcher — Android TV launcher
    val AT4K_COMPATIBILITY = Compatibility(
        name = "AT4K Launcher (Android TV)",
        packageName = "com.overdevs.at4k",
        appIconColor = 0x98B098,
        targets = listOf(AppTarget(version = "0.99", versionCode = 12))
    )
}
