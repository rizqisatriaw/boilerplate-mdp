// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.hilt.android) apply false
//    id("com.google.devtools.ksp") version "1.8.21-1.0.11" apply false
//    alias(libs.plugins.compose.compiler) apply false
}