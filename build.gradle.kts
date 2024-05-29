plugins {
    kotlin("jvm") version "1.9.23"
}

group = "net.littlexfish"
version = "0.2.1-beta"

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
tasks.jar {
    manifest {
        attributes["Main-Class"] = "net.littlexfish.xmldsl.MainKt"
    }
    dependsOn(configurations.compileClasspath)
    from({
        configurations.compileClasspath.get().filter {
            it.name.endsWith("jar")
        }.map { zipTree(it) }
    }) {
        exclude("META-INF/*.RSA", "META-INF/*.SF", "META-INF/*.DSA")
    }
}