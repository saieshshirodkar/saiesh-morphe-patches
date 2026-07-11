package app.template.patches.shared

import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

object Constants {
    // AT4K Launcher — Android TV launcher
    val AT4K_COMPATIBILITY = Compatibility(
        name = "AT4K Launcher (Android TV)",
        packageName = "com.overdevs.at4k",
        appIconColor = 0x98B098,
        targets = listOf(AppTarget(version = "0.99", versionCode = 12))
    )
}
