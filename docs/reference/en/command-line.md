# Command Line

Usage: java -jar xml-dsl.jar [options] <input-file>

Options:
- `-h`, `--help`: Print this help message and exit
- `-v`, `--version`: Print the version information and exit
- `-o <directory>`, `--output <directory>`: Specify the output directory for files (default is the input file's directory)
- `--`: Specify input from terminal or via pipeline
- `++`: Specify output to terminal or via pipeline
- `--pretty-print`: Output in pretty print format
- `--shorten-empty`: Use short form for empty elements
- `--input-charset <charset>`: Specify input character set (default is UTF-8)
- `--output-charset <charset>`: Specify output character set (default is UTF-8)
- `--indent <string>`: Specify the string used for indentation (default is \t)
- `--mode <mode>`: Specify the output parsing mode (default is xml, can be xml or html)
- `-e <key=value>`, `--env <key=value>`: Add a global environment variable
- `<input-file>`: The input file to be processed

Examples:
```shell
java -jar xml-dsl.jar -h
```

```shell
java -jar xml-dsl.jar --version
```

```shell
java -jar xml-dsl.jar -o ./output-dir --input-charset UTF-16 --output-charset UTF-16 --indent "  " input.xml
```

```shell
java -jar xml-dsl.jar -o ./output-dir --output-charset UTF-16 --mode html input.html
```