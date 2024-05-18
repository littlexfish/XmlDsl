plugins {
    kotlin("jvm")
}

group = "net.littlexfish"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/org.antlr/antlr4
    implementation("org.antlr:antlr4:4.13.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}