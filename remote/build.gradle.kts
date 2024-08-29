plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}
dependencies{
    implementation(libs.ktor.client.core)
    implementation(libs.kotlinx.coroutines.core)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}