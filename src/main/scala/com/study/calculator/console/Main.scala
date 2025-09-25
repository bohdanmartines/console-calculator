package com.study.calculator.console

import com.study.calculator.console.Calculator.calculate

import scala.annotation.tailrec
import scala.io.StdIn.readLine

val LinePrefix = "calc>"
val Pattern = raw"([+-]?\d*\.?\d+)\s*([+\-*/^])\s*([+-]?\d*\.?\d+)".r

@main def app(): Unit =
  println("Welcome to Console Calculator!")
  repl()

@tailrec
def repl(): Unit =
  println("Type an operation. Examples: 1 + 2 | 4.1 - 1 | 2 * 3 | 6 / 2 | 3.2 ^ 2")
  val input = readLine(LinePrefix)

  if input == null || input.equals(":q") then
    println("Bye!")
  else if input.trim.isEmpty then
    repl()
  else
    val result = input.trim match
      case Pattern(a, operation, b) => calculate(BigDecimal(a), operation, BigDecimal(b))
      case other => Left("Invalid input!")
    result.fold(error => println(error), res => println(s"Result is [$res]"))
    repl()