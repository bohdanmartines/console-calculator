package com.study.calculator.console

import scala.io.StdIn.readLine

object Main {

  val Pattern = raw"(\d+)[+\-*/^](\d+)".r

  enum Operation:
    case Add, Substruct, Multiply, Divide, Power

  def repl(): Unit = {
    println("Examples:  2 + 3 | 3 * 4 | 3 ^ 2")
    val input = readLine("calc> ")
    println(s"You entered [$input]")

    if input == null || input.trim == ":q" then
      print("bye!")
    else if input.trim.isEmpty then
      repl()
    else
      val result = input match
        case Pattern(a, operation, b) => calculate(a.toInt, operation, b.toInt)
      println(s"Result is [$result]")
      repl()
  }

  def calculate(a: Int, operation: String, b: Int) = {
    s"Placeholder for result"
  }

  @main def calculator() =
    println("Console Calculator. Print :q to quit")
    repl()
}