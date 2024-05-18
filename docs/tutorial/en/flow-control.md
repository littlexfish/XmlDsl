# Flow Control

Flow control refers to the ability to control the flow of execution
within a program. In XmlDsl, flow control is achieved using the following
constructs:

## Conditional Statements

Conditional statements allow you to execute code based on a condition.
In XmlDsl, you can use the `if` statement to execute code if a condition
is true, and the `else` statement to execute code if the condition is false.

Example:

```
html {
    val title = "Hello, World!"
    head {
        title { title }
    }
    body {
        if title == "Hello, World!" {
            h1 { title }
        }
        else {
            h2 { "Hello, World!" }
        }
    }
}
```

In this example, the `if` statement checks if the `title` variable
is equal to `"Hello, World!"`. If the condition is true, the `h1` element
is generated with the `title` variable as its text content.
If the condition is false, the `h2` element is generated with the text
content `"Hello, World!"`.

Note that parentheses are not required around the condition in XmlDsl.

## While Loops

While loops allow you to execute code repeatedly while a condition is true.

Example:

```
html {
    var count = 0
    body {
        while count < 5 {
            p { "Count: $count" }
            count += 1
        }
    }
}
```

In this example, the `while` loop executes the code block inside the loop
while the `count` variable is less than `5`. The `p` element is generated
with the text content `"Count: $count"`, and the `count` variable is
incremented by `1` in each iteration.

## For Loops

For loops allow you to iterate over a range of values and execute code
for each value.

Example:

```
html {
    body {
        for i in 1..5 {
            p { "Count: $i" }
        }
    }
}
```

In this example, the `for` loop iterates over the range `1..5` and generates
the `p` element with the text content `"Count: $i"` for each value of `i`
in the range.

Note that ranges in XmlDsl are (begin, end], meaning that the
beginning value is inclusive, and the ending value is exclusive.  
Note that parentheses are not required around the range in XmlDsl.

## Break and Continue

You can use the `break` statement to exit a loop prematurely, and the
`continue` statement to skip the rest of the code block and continue
with the next iteration of the loop.

Example:

```
html {
    body {
        for i in [1, 2, 3, 4, 5] {
            if i == 3 {
                break
            }
            p { "Count: $i" }
        }
    }
}
```

In this example, the `for` loop iterates over the list `[1, 2, 3, 4, 5]`
and generates the `p` element with the text content `"Count: $i"` for each
value of `i`. If `i` is equal to `3`, the `break` statement is executed,
and the loop is exited prematurely.

## Return

**Note:** The `return` statement is not supported in XmlDsl, but it is kept here for completeness.

## [Previous: Variable Scope](var-scope.md) | [Next: Comparison Operators](comp.md)
