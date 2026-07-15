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

    val PICTUREMUSHROOM_COMPATIBILITY = Compatibility(
        name = "Picture Mushroom",
        packageName = "com.glority.picturemushroom",
        appIconColor = 0x7BC67E,
        targets = listOf(AppTarget(version = "2.9.31", versionCode = 90))
    )

    val PROJECTIVY_COMPATIBILITY = Compatibility(
        name = "Projectivy Launcher",
        packageName = "com.spocky.projengmenu",
        appIconColor = 0xFFDD00,
        targets = listOf(AppTarget(version = "4.71", versionCode = 95))
    )
}
