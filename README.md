# XmlDsl

![Build](https://img.shields.io/badge/build-passing-2ecc40)
![Coverage](https://img.shields.io/badge/coverage-71%25-ff851b)
![Version](https://img.shields.io/badge/version-0.1.0-0074d9)

A simple DSL for XML.

## Overview

The project is a simple DSL for XML. It is designed to be easy to use and easy to understand.

## Usage

Write a file called `example.xd` then use the following command
to convert it to XML into output/example.xml.

```shell
java -jar xml-dsl.jar --pretty-print --shorten-empty -o output/ example.xd
```

If you want to convert to HTML instead, add `--mode html` to the command.

```shell
java -jar xml-dsl.jar --pretty-print --shorten-empty --mode html -o output/ example.xd
```

## Development

For developers who want to contribute to the project, please visit the [Development Page](docs/development/en/index.md).

## Language and Frameworks

The project is developed using the following languages and frameworks:

- Kotlin
- Java
- Gradle

## Dependencies

The project uses the following dependencies:

- [ANTLR](https://www.antlr.org/): Generated parser
- [JUnit](https://junit.org/): Unit testing

WIP

