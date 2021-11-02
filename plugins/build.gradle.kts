plugins {
  `kotlin-dsl`
}

repositories {
  mavenCentral()
}

gradlePlugin {
  plugins {
    create("dependencies") {
      id = "com.zuhriyansauqi.plugins"
      implementationClass = "com.zuhriyansauqi.plugins.DependenciesPlugin"
    }
  }
}
