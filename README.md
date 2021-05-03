# Math

![GitHub Workflow Status (branch)](https://img.shields.io/github/workflow/status/SpongePowered/math/Build,%20Test,%20and%20Deploy/master) [![MIT License](https://img.shields.io/badge/license-MIT-blue)](LICENSE.txt) [![Maven Central](https://img.shields.io/maven-central/v/org.spongepowered/math?label=stable)](https://search.maven.org/search?q=g:org.spongepowered%20AND%20a:math) ![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/org.spongepowered/math?label=dev&server=https%3A%2F%2Foss.sonatype.org)

Immutable math library for Java that offers easy conversion between math types, fast trigonometric functions, vectors, matrices, complex numbers, quaternions, and operation chaining, with a focus on games and computer graphics.

* [Source]
* [Issues]
* [Development Discord] `#sponge`

## Prerequisites

* Java 8

## Building

In order to build math you simply need to run the `./gradlew build` command. You can find the compiled JAR file in `./build/libs` labeled 
similarly to 'math-x.x.x-SNAPSHOT.jar'.

## Contributing

Are you a talented programmer looking to contribute some code? We'd love the help!
* Open a pull request with your changes, following our [guidelines](CONTRIBUTING.md).

## Usage

Releases are published to Sponge's own repository, Maven Central, and GitHub Packages. 
Snapshots are published to Sponge's repository and Sonatype OSS.

If you're using [Gradle] to manage project dependencies, simply include the following in your `build.gradle` file:
```gradle
repositories {
  mavenCentral()

  // Alternatively
  maven {
    url "https://repo.spongepowered.org/repository/maven-public"
    name "sponge"
  }
}

dependencies {
  implementation "org.spongepowered:math:2.0.0"
}
```

If you're using [Maven] to manage project dependencies, simply include the following in your `pom.xml` file:
```xml
<dependency>
  <groupId>org.spongepowered</groupId>
  <artifactId>math</artifactId>
  <version>2.0.0</version>
</dependency>
```

## Credits
* [Spout](https://spout.org/) and contributors - *where we all began, and for much of the re-licensed code.*
* All the people behind [Java](http://www.oracle.com/technetwork/java/index.html), [Maven], and [Gradle].

[Gradle]: https://gradle.org
[Maven]: https://maven.apache.org/
[Source]: https://github.com/SpongePowered/math
[Issues]: https://github.com/SpongePowered/math/issues
[License]: https://opensource.org/licenses/MIT
[Development Discord]: https://discord.gg/sponge
