package com.study.calculator.console

import scala.annotation.tailrec
import scala.io.StdIn.readLine

val LinePrefix = "calc>"
val Pattern = raw"(\d+)\s*([+\-*/])\s*(\d+)".r

@main def app(): Unit =
  println("Welcome to Console Calculator!")
  repl()

@tailrec
def repl(): Unit =
  println("Type an operation. Examples: 1 + 2 | 4 - 1 | 2 * 3 | 6 / 2")
  val input = readLine(LinePrefix)
  println(s"You entered [$input]")

  if input == null || input.equals(":q") then
    println("Bye!")
  else if input.trim.isEmpty then
    repl()
  else
    // TODO Add handling user input
    input match
      case Pattern(a, operation, b) =>
        val result = calculate(a, operation, b)
        println(s"Result is [$result]")
      case other =>
    repl()

def calculate(str: String, str1: String, str2: String): Double =
  0.0 // TODO Placeholder