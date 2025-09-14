package com.study.calculator.console

object Main {
  enum Operation:
    case Add, Substruct, Multiply, Divide, Power

  @main def calculator() =
    println("Console Calculator. Print :q to quit")
    println("Examples:  2 + 3 | 3 * 4 | 3 ^ 2")
}