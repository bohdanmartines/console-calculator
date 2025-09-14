package com.study.calculator.console

import scala.io.StdIn.readLine

object Main {
  enum Operation:
    case Add, Substruct, Multiply, Divide, Power

  def repl(): Unit = {
    val input = readLine("calc> ")
    println(s"You entered [$input]")
    if input == null || input.trim == ":q" then
      print("bye!")
    else
      repl()
  }

  @main def calculator() =
    println("Console Calculator. Print :q to quit")
    println("Examples:  2 + 3 | 3 * 4 | 3 ^ 2")
    repl()
}