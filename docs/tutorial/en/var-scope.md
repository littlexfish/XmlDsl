# Variable Scope

## Introduction

Variable scope refers to the visibility and 
accessibility of variables within a program.

In XmlDsl, variables can have different scopes
depending on where they are declared.

## Local Scope

Local scope refers to variables that are declared
within a block of code, such as an element or flow control block.

Local variables are only accessible within the block
in which they are declared.

Example:

```
html {
    val title = "Hello, World!"
    head {
        title { title }
    }
    body {
        h1 { title }
    }
}
```

In this example, the `title` variable is declared
within the `html` block and is only accessible
within the `head` and `body` blocks.

## Global Scope

Global scope refers to variables that are declared
outside any block of code.

Global variables are accessible from anywhere
within the program.

Example:

```
val title = "Hello, World!"

html {
    head {
        title { title }
    }
    body {
        h1 { title }
    }
}
```

In this example, the `title` variable is declared
outside any block and is accessible from within
the `html`, `head`, and `body` blocks.

## [Previous: Variables Type](var-type.md) | [Next: Flow Control](flow-control.md)

