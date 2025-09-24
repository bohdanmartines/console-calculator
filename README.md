# Console Calculator

A simple console-based calculator application written in Scala. The calculator supports basic arithmetic operations: addition, subtraction, multiplication, division, and power.

## Features

- Interactive REPL-like interface
- Supports operators: `+`, `-`, `*`, `/`, `^`
- Graceful handling of invalid input
- Quit anytime with `:q`

## Getting Started

### Prerequisites
- Java JDK 17+
- [Scala 3](https://www.scala-lang.org/download/)
- [sbt](https://www.scala-sbt.org/)

### Run the app

1. Clone the Git repository or download the project files.
2. Navigate to the project folder in your terminal.
3. Run the following command to start the application:
   ```bash
   sbt run
   ```
4. Follow the interactive prompts to perform calculations.

## Input Rules

- The input must follow the format: `<number> <operator> <number>`. Spaces are optional.
  - **Example**: `5 + 3`, `4.1 - 2.7`, `3.5 ^ 3`
- Supported operators:
  - `+` for addition
  - `-` for subtraction
  - `*` for multiplication
  - `/` for division
  - `^` for power
- Numbers must be integers.
- Division by zero is not allowed.
- To exit the application, type `:q`.

Invalid inputs will return an error message.

Enjoy using the Console Calculator!