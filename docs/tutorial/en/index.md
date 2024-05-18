# XmlDsl Tutorial

## Introduction

XmlDsl is a programming language that allows you 
to generate XML or HTML files in a more readable and maintainable way. 
It is a domain-specific language (DSL) that provides a set of
syntax rules to define elements and attributes.

## Getting Started

To generate your first HTML file using XmlDsl, 
you need to create a new file, and add the following code:

```
html {
    head {
        title { "Hello, World!" }
    }
    body {
        h1 { "Hello, World!" }
    }
}
```

By using the command line

```shell
java -jar xml-dsl.jar -o output.html input.wd
```

This code will generate the following HTML file:

```html
<html>
    <head>
        <title>Hello, World!</title>
    </head>
    <body>
        <h1>Hello, World!</h1>
    </body>
</html>
```

## Define Elements

You can define elements using the following syntax:

```
elementName {
    attr attribute1 = "value1"
    attr attribute2 = "value2"
    ...
    "text content"
}
```

For example, to define a `div` element with a `class` attribute,
you can use the following code:

```
div {
    attr class = "container"
    "Hello, World!"
}
```

This code will generate the following HTML code:

```html
<div class="container">Hello, World!</div>
```

## [Next: Variables Declaration](var-decl.md)
