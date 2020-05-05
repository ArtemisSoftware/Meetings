plugins {
    kotlin("jvm") version "1.3.60"/*tive que baixar da versao 71 para a serializacao funcionar!!*/
    id("org.jetbrains.kotlin.plugin.serialization") version "1.3.60"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))


    implementation ("org.jetbrains.kotlin:kotlin-reflect:1.3.71")
    implementation ("log4j:log4j:1.2.17")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.14.0")
    //implementation (kotlin("log4j:log4j:1.2.17""))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}