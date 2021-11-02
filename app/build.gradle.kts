import com.zuhriyansauqi.plugins.DependenciesPlugin

plugins {
  id("com.android.application")
  id("com.zuhriyansauqi.plugins")
  kotlin("android")
  kotlin("kapt")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdk = 31

  defaultConfig {
    applicationId = "com.zuhriyansauqi.boilerplate"
    minSdk = 21
    targetSdk = 31
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }

  buildFeatures {
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = DependenciesPlugin.composeVersion
  }

  packagingOptions {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  // Android
  implementation(DependenciesPlugin.Android.coreKtx)
  implementation(DependenciesPlugin.Android.appCompat)
  implementation(DependenciesPlugin.Android.material)
  implementation(DependenciesPlugin.Android.lifecycleRuntimeKtx)
  androidTestImplementation(DependenciesPlugin.Test.extJunit)
  androidTestImplementation(DependenciesPlugin.Test.espresso)

  // Coroutines
  implementation(DependenciesPlugin.Coroutines.core)
  implementation(DependenciesPlugin.Coroutines.android)

  // Jetpack Compose
  implementation(DependenciesPlugin.Compose.ui)
  implementation(DependenciesPlugin.Compose.uiTooling)
  implementation(DependenciesPlugin.Compose.uiToolingPreview)
  implementation(DependenciesPlugin.Compose.foundation)
  implementation(DependenciesPlugin.Compose.material)
  implementation(DependenciesPlugin.Compose.materialIcon)
  implementation(DependenciesPlugin.Compose.materialIconExt)

  // Jetpack Compose Integration
  implementation(DependenciesPlugin.ComposeIntegration.activity)
  implementation(DependenciesPlugin.ComposeIntegration.navigation)
  implementation(DependenciesPlugin.ComposeIntegration.hiltNavigation)

  // DaggerHilt
  implementation(DependenciesPlugin.DaggerHilt.android)
  kapt(DependenciesPlugin.DaggerHilt.compiler)

  // Room
  implementation(DependenciesPlugin.Room.runtime)
  kapt(DependenciesPlugin.Room.compiler)
  implementation(DependenciesPlugin.Room.ktx)
  testImplementation(DependenciesPlugin.Room.testing)

  // Test
  testImplementation(DependenciesPlugin.Test.jUnit4)
  androidTestImplementation(DependenciesPlugin.Compose.uiTestJUnit4)
}

// Dagger Hilt: Allow references to generated code
kapt {
  correctErrorTypes = true
}
