# Variable Type

## Introduction

In XmlDsl, there has 6 types of variables. They are:

- number
- string
- boolean
- list
- empty
- null

## Number

Number is a type of variable in XmlDsl that can store numeric values. 
It can be an integer or a floating point number.

### Examples:

- `0` // An integer number
- `123` // An integer number
- `123.45` // A floating point number
- `-123` // A negative integer number
- `-123.45` // A negative floating point number
- `0.123` // A floating point number less than 1
- `-0.123` // A negative floating point number less than 1
- `0x123abc` // A hexadecimal number
- `0X123abc` // A hexadecimal number
- `0b1010` // A binary number
- `0B1010` // A binary number
- `0o7654` // An octal number
- `0O7654` // An octal number
- `1_000_000` // An integer number with underscores for readability

In XmlDsl, numbers can be represented in various formats including integers, 
floating point numbers, negative numbers, and numbers in binary, octal, 
and hexadecimal formats.

## String

String is a type of variable that can store text values.

To form a string, you can use single quotes or double quotes.
Also, you can use dollar sign `$` to form a string with variables like Kotlin Language.

Examples:
- `'Hello, World!'` // A string enclosed in single quotes
- `"Hello, World!"` // A string enclosed in double quotes
- `'Hello, $name!'` // name is a variable
- `"Hello, $name!"` // name is a variable
- `'Hello, ${name}!'` // name is a variable
- `"Hello, ${name}!"` // name is a variable

Multiline string is also supported.

Examples:

- ```text 
  'Hello,
  World!'
  ```
- ```text
  "Hello,
  World!"
  ```
- ```text
  'Hello,
  $name!'
  ```
- etc.



## Boolean

Boolean is a type of variable in XmlDsl that can store true or false values.

Examples:

- `true` // A boolean value representing true
- `false` // A boolean value representing false

In XmlDsl, boolean values are primarily used in conditional statements and loops for control flow.

## List

List is a type of variable that can store multiple values of any type. Each value in the list is called an element. The elements in a list are ordered and accessible by their index, which starts from 0 for the first element.

To form a list, you can use square brackets `[]` and separate each element with a comma `,`.

Examples:

- `[]` // An empty list
- `[1, 2, 3]` // A list of numbers
- `['Hello', 'World']` // A list of strings
- `[true, false, true]` // A list of booleans
- `[1, 'Hello', true]` // A list with a number, a string, and a boolean
- `[[1, 2], [3, 4]]` // A list of lists (nested list)

### Accessing Elements:

**Not implement**
You can access an element in a list by its index. 
For example, if `numbers` is a list, 
you can access the first element with `numbers[0]`.

### Modifying Elements:

You can modify an element in a list by its index.
For example, if `numbers` is a list and can be modified, 
you can change the first element with `numbers[0] = new_value`.

### Adding Elements:

You can use `+` to add an element to a list.

Examples:

- `[] + 1` // Return `[1]`
- `[1, 2, 3] + 4` // Return `[1, 2, 3, 4]`
- `[1, 2, 3] + [4]` // Return `[1, 2, 3, 4]`
- `[1, 2, 3] + [4, 5]` // Return `[1, 2, 3, 4, 5]`

### Removing Elements:

You can use `-` to remove an element from a list.

Examples:

- `[1, 2, 3] - 2` // Return `[1, 3]`
- `[1, 2, 3] - [2]` // Return `[1, 3]`
- `[1, 2, 3] - [1, 2]` // Return `[3]`
- `[1, 2, 3] - [1, 2, 3]` // Return `[]`
- `[1, 2, 3] - [4]` // Return `[1, 2, 3]`
- `[1, 2, 3] - [4, 5]` // Return `[1, 2, 3]`

## Empty

Empty is a type of variable in XmlDsl that represents an absence of a value. 
It is used to indicate that a variable has been declared but not yet assigned a value.

Example:

- `empty` // An empty value

In XmlDsl, `empty` is primarily used to initialize a variable that 
will be assigned a value later in the program.

## Null

Null is a type of variable in XmlDsl that represents a null or non-existent value. 
It is used to indicate that a variable's value is undefined or not known.

Example:

- `null` // A null value

In XmlDsl, `null` is primarily used to represent the absence of value or 
to indicate that a variable's value is not yet known or not applicable.

## [Previous: Variables Declaration](var-decl.md) | [Next: Variable Scope](var-scope.md)

