package com.study.calculator.console

import com.study.calculator.console.Operation.{Add, Divide, Multiply, Substruct}

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object Main {

  val Pattern = raw"(\d+)\s*([+\-*/^])\s*(\d+)".r

  @tailrec
  private def repl(): Unit = {
    println("Examples:  2 + 3 | 5 - 3 | 3 * 4 | 6 / 2")
    val input = readLine("calc> ")
    println(s"You entered [$input]")

    if input == null || input.trim == ":q" then
      print("bye!")
    else if input.trim.isEmpty then
      repl()
    else
      val result = input.trim match
        case Pattern(a, operation, b) =>
          Operation.parse(operation) match
            case Right(x) => calculate(a.toInt, x, b.toInt)
            case left @ Left(_) => left
        case _ => Left("Invalid input")
      result match
        case Right(x) => println(s"Result is [$x]")
        case Left(x) => println(x)
      repl()
  }

  private def calculate(a: Double, operation: Operation, b: Double): Either[String, Double] = {
    operation match
      case Add => Right(a + b)
      case Substruct => Right(a - b)
      case Multiply => Right(a * b)
      case Divide =>
        if b == 0 then
          Left("Cannot divide by zero!")
        else
          Right(a / b)
  }

  @main def calculator(): Unit =
    println("Console Calculator. Print :q to quit")
    repl()
}