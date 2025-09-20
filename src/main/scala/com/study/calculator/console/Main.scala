package com.study.calculator.console

import scala.io.StdIn.readLine

object Main {

  val Pattern = raw"(\d+)\s*([+\-*/^])\s*(\d+)".r

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
      val result = input.trim match
        case Pattern(a, operation, b) => Some(calculate(a.toInt, operation, b.toInt))
        case _ => None
      result match
        case Some(x) => println(s"Result is [$result]")
        case None => println("Invalid input")
      repl()
  }

  def calculate(a: Int, operation: String, b: Int): Double = {
    123.456 // TODO Placeholder
  }

  @main def calculator() =
    println("Console Calculator. Print :q to quit")
    repl()
}