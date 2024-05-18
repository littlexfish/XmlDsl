# Variables Declaration

## Define Variables

You can define variables using `val`.

```
val variable = "value"
```

Of course, you can use this variable in your code.

```
val variable = "value"
attr id = variable
```

## Mutable Variables

When you need to change the value of variables, you may get some error.

```
val variable = "value"
variable = "new value" // error
```

To solve this problem, you can use `var`.

```
var variable = "value"
variable = "new value" // ok
```

## Attribute

Before here, you might found that some variables is use `attr` to define.

If you define a variable with `attr`, 
it will be an attribute, 
and you can always modify the value of it like normal `var` variables.

```
example {
    val v1 = "value1"
    attr v2 = "value2"
}
```

This code will generate the following XML code:

```xml
<example v2="value2"></example>
```

## [Previous: Getting Started](index.md) | [Next: Variable Types](var-type.md)

