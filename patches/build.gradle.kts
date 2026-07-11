group = "app.saiesh.morphe-patches"

patches {
    about {
        name = "Saiesh's Patches"
        description = "Patches for apps requested by people"
        source = "https://github.com/saiesh/saiesh-morphe-patches"
        author = "saiesh"
        contact = "https://github.com/saiesh"
        website = "https://github.com/saiesh/saiesh-morphe-patches"
        license = "GPLv3"
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xcontext-parameters")
    }
}

val patchListGeneratorClasspath: Configuration by configurations.creating

dependencies {
    compileOnly(libs.gson)
    patchListGeneratorClasspath(libs.gson)
}

tasks {
    register<JavaExec>("generatePatchesList") {
        description = "Build patch with patch list"
        dependsOn(build)
        classpath = sourceSets["main"].runtimeClasspath + patchListGeneratorClasspath
        mainClass.set("util.PatchListGeneratorKt")
    }

    publish {
        dependsOn("generatePatchesList")
    }
}
