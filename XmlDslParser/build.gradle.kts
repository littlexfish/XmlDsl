plugins {
    kotlin("jvm")
}

group = "net.littlexfish"
version = "0.1.3-beta"

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
tasks.register<Copy>("generateVersion") {
    from("src/main/kotlin/net/littlexfish/xmldslparser/Lib.kt") {
        filter { line ->
            if (line.startsWith("const val version = ")) {
                return@filter "const val version = \"$version\""
            }
            return@filter line
        }
    }
    into("build/generated/auto/")
    copy {
        from("build/generated/auto/Lib.kt")
        into("src/main/kotlin/net/littlexfish/xmldslparser")
    }
    delete("build/generated/auto/Lib.kt")
}