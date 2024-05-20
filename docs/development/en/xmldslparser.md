# Core Module(XmlDslParser)

## Overview

The core module of the project is the base module of the project.
It contains the base parser.

## Structure

`src/main/kotlin` is main source directory of the module, use Kotlin language to write the code.
If you need to write tests, use `src/test/kotlin` directory.

Also, you can write the code in Java language, but it is not recommended.
If you need to write the code in Java, use `src/main/java` and `src/test/java` directories.

Package `antlr` contains the grammar output files, all file in this package should not be modified manually.\
Package `server` contains the main parser server class, it calls "server", but not actually a server, just serve-er.\
root package contains the main library class interfaces.

## TODO List

Design details will create as feature issues.

- [ ] `include` function
- [ ] `import` function
- [ ] `export` function
- [ ] add function type
- [ ] add function call
- [ ] add type process
- [ ] code highlighter

## Well-known Issues

WIP
