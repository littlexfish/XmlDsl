# Comparison Operators

## Equality

The `==` operator is used to compare two values for equality. 
If the values are equal, the expression evaluates to `true`, otherwise it evaluates to `false`.

Example:

```
val a = 5
val b = 5

if a == b {
    p { "a is equal to b" }
}
```

In this example, the `if` statement checks if the variables `a` and `b` are equal.
If they are equal, the `p` element is generated with the text content `"a is equal to b"`.
If they are not equal, the `p` element is not generated.

## Inequality

The `!=` operator is used to compare two values for inequality.
If the values are not equal, the expression evaluates to `true`, otherwise it evaluates to `false`.

Example:

```
val a = 5
val b = 10

if a != b {
    p { "a is not equal to b" }
}
```

In this example, the `if` statement checks if the variables `a` and `b` are not equal.
If they are not equal, the `p` element is generated with the text content `"a is not equal to b"`.

## Comparison

The comparison operators `<`, `>`, `<=`, and `>=` are used to compare two values.
These operators evaluate to `true` if the comparison is true, and `false` if the comparison is false.

Example:

```
val a = 5
val b = 10

if a < b {
    p { "a is less than b" }
}

if a > b {
    p { "a is greater than b" }
}

if a <= b {
    p { "a is less than or equal to b" }
}

if a >= b {
    p { "a is greater than or equal to b" }
}
```

In this example, the `if` statements check the relationships between the variables `a` and `b`.
The `p` elements are generated based on the results of the comparisons.

## Logical Operators

Logical operators are used to combine multiple conditions in an expression.

### AND

The `&&` operator is used to combine two conditions with a logical AND.
The expression evaluates to `true` if both conditions are true, otherwise it evaluates to `false`.

Example:

```
val a = 5
val b = 10

if a < 10 && b > 5 {
    p { "Both conditions are true" }
}
```

In this example, the `if` statement checks if both conditions are true.
If both conditions are true, the `p` element is generated with the text content `"Both conditions are true"`.
If either condition is false, the `p` element is not generated.

### OR

The `||` operator is used to combine two conditions with a logical OR.
The expression evaluates to `true` if at least one of the conditions is true, otherwise it evaluates to `false`.

Example:

```
val a = 5
val b = 10

if a < 10 || b < 5 {
    p { "At least one condition is true" }
}
```

In this example, the `if` statement checks if at least one of the conditions is true.
If at least one condition is true, the `p` element is generated with the text content `"At least one condition is true"`.
If both conditions are false, the `p` element is not generated.

### NOT

The `!` operator is used to negate a condition.
If the condition is true, the expression evaluates to `false`, 
and if the condition is false, the expression evaluates to `true`.

Example:

```
val a = 5
    
if !(a > 10) {
    p { "a is not greater than 10" }
}
```

In this example, the `if` statement negates the condition `a > 10`.
If the condition is false, the `p` element is generated with the text content `"a is not greater than 10"`.
If the condition is true, the `p` element is not generated.
    
## in Operator

The `in` operator is used to check if a value is in a collection.

Example:

```
val numbers = [1, 2, 3, 4, 5]

if 3 in numbers {
    p { "3 is in the list" }
}
```

In this example, the `if` statement checks if the value `3` is in the `numbers` list.
If the value is in the list, the `p` element is generated with the text content `"3 is in the list"`.
If the value is not in the list, the `p` element is not generated.

## Range Operator

The range operator `..` is used to create a list of values.

Example:

```
val range = 1..5

for i in range {
    p { "Value: $i" }
}
```

In this example, the `range` variable is assigned the values from `1`(inclusive) to `5`(exclusive).
The `for` loop iterates over the values in the range and generates a `p` element for each value.

## [Previous: Flow Control](flow-control.md)
