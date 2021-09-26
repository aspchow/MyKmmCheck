buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        val kotlinVersion = "1.5.21"
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
        classpath("com.android.tools.build:gradle:7.1.0-alpha12")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")

    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
