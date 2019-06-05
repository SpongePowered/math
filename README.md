# math [![Build Status](http://img.shields.io/travis/SpongePowered/math/develop.svg?style=flat)](https://travis-ci.org/SpongePowered/math) [![License](http://img.shields.io/badge/license-MIT-lightgrey.svg?style=flat)][License] [![Coverage Status](https://coveralls.io/repos/github/SpongePowered/math/badge.svg)](https://coveralls.io/github/SpongePowered/math)

Immutable math library for Java that offers easy conversion between math types, fast trigonometric functions, vectors, matrices, complex numbers, quaternions, and operation chaining, with a focus on games and computer graphics.

* [Source]
* [Issues]
* [Community Discord]
* [Development IRC]: [#spongedev on irc.esper.net]

## Prerequisites
* Java 8

## Building
In order to build math you simply need to run the `mvn clean package` command. You can find the compiled JAR file in `./target` labeled similarly to 'math-x.x.x-SNAPSHOT.jar'.

## Contributing
Are you a talented programmer looking to contribute some code? We'd love the help!
* Open a pull request with your changes, following our [guidelines](CONTRIBUTING.md).

## Usage
If you're using [Gradle] to manage project dependencies, simply include the following in your `build.gradle` file:
```gradle
repositories {
  maven {
    url 'https://repo.spongepowered.org/maven/'
  }
}

dependencies {
  implementation 'org.spongepowered:math:1.0.4-SNAPSHOT'
}
```

If you're using [Maven] to manage project dependencies, simply include the following in your `pom.xml` file:
```xml
<dependency>
  <groupId>org.spongepowered</groupId>
  <artifactId>math</artifactId>
  <version>1.0.4-SNAPSHOT</version>
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
[Community Discord]: https://discord.gg/PtaGRAs
[Development IRC]: https://webchat.esper.net/?channels=spongedev
