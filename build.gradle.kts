import org.spongepowered.gradle.math.templates.GenerateTemplates

plugins {
    jacoco
    id("org.spongepowered.gradle.sponge.dev") version "1.1.0-SNAPSHOT"
    id("math-templates")
    id("net.kyori.indra.publishing.sonatype")  version "2.0.1"
}

// -- General setup -- //

group = "org.spongepowered"
version = "2.0.0-SNAPSHOT"
description = "Immutable math library for Java with a focus on games and computer graphics."

repositories {
    maven("https://repo.spongepowered.org/repository/maven-public/") {
        name = "sponge"
    }
}

val floatData = file("src/templateData/float.yaml")
val intData = file("src/templateData/integer.yaml")
sourceSets {
    main {
        templates.templateSets {
            register("float") {
                dataFiles.from(floatData)
                variants("float", "double")
            }
            register("integer") {
                dataFiles.from(intData)
                variants("int", "long")
            }
            // no variants
            register("floatCommon") {
                dataFiles.from(floatData)
            }
        }
    }
    test {
        templates.templateSets {
            register("integer") {
                dataFiles.from(intData)
                variants("int", "long")
            }
            register("float") {
                dataFiles.from(floatData)
                variants("float", "double")
            }
        }
    }
}

dependencies {
    testImplementation("junit:junit:4.13.1")
}

tasks {
    withType(Test::class) {
        useJUnit() // junit 4
    }

    jar {
        from(rootProject.file("LICENSE.txt")) {
            rename { "LICENSE-spongepowered-math.txt" }
        }
    }

    withType(JavaCompile::class) {
        options.compilerArgs.add("-Xlint:-cast") // skip cast warnings, the generated source is most likely just overly safe.

    }

    // Put a license header on generated source
    withType(GenerateTemplates::class) {
        finalizedBy(licenseFormat)
    }
}

// Metadata

spongeConvention {
    mitLicense()
    licenseParameters {
        val organization: String by project
        val url: String by project
        this["name"] = "Math"
        this["organization"] = organization
        this["url"] = url
    }

    sharedManifest {
        attributes("Specification-Title" to project.name,
        "Specification-Vendor" to "SpongePowered - https://spongepowered.org",
        "Automatic-Module-Name" to "${project.group}.math")
    }
}

// -- Publishing -- //
indra {
    javaVersions {
        testWith(8, 11, 16)
    }
    configurePublications {
            pom {
                name.set("Math")
                inceptionYear.set("2013")

                developers {
                    developer {
                        id.set("DDoS")
                        name.set("Aleksi Sapon")
                        email.set("qctechs@gmail.com")
                    }
                    developer {
                        id.set("kitskub")
                        name.set("Jack Huey")
                        email.set("kitskub@gmail.com")
                    }
                    developer {
                        id.set("Wolf480pl")
                        name.set("Wolf480pl")
                        email.set("wolf480@interia.pl")
                    }
                    developer {
                        id.set("lukespragg")
                        name.set("Luke Spragg")
                        email.set("the@wulf.im")
                    }
                }
            }
        }
    }
