// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  id("com.diffplug.spotless") version "5.17.1"
}

buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:7.0.3")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
    classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1")

    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle.kts files
  }
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
  kotlin {
    target("**/*.kt")
    ktlint()
      .userData(mapOf("indent_size" to "2", "continuation_indent_size" to "2"))
    ktfmt().googleStyle()
  }

  kotlinGradle {
    target("**/*.gradle.kts")
    ktlint()
      .userData(mapOf("indent_size" to "2", "continuation_indent_size" to "2"))
  }
}
