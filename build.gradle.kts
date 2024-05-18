plugins {
    kotlin("jvm") version "1.9.23"
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
    implementation(project(":XmlDslParser"))
}
tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}