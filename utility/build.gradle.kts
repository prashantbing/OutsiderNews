import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("com.github.gmazzo.buildconfig") version "5.4.0"

}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "utility"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.multiplatform.utility"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

val  properties =  Properties()
properties.load(project.rootProject.file("local.properties").inputStream())


buildConfig {
    buildConfigField("APP_NAME", project.name)
    buildConfigField("APP_VERSION", provider { "\"${project.version}\"" })
    buildConfigField("API_KEY",  properties.getProperty("API_KEY"))
    buildConfigField("BASE_URL",  properties.getProperty("BASE_URL"))

}