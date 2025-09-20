package com.study.calculator.console

import com.study.calculator.console.Operation.{Add, Divide, Multiply, Power, Substruct}

import scala.annotation.tailrec
import scala.io.StdIn.readLine

val LinePrefix = "calc>"
val Pattern = raw"(\d+)\s*([+\-*/^])\s*(\d+)".r

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
    val result = input.trim match
      case Pattern(a, operation, b) => calculate(a.toInt, operation, b.toInt)
      case other => Left("Invalid input!")
    result.fold(error => println(error), res => println(s"Result is [$res]"))
    repl()

def calculate(a: Int, operation: String, b: Int): Either[String, Double] =
  Operation.fromString(operation) match
    case Right(value) => calculate(a, value, b)
    case Left(error) => Left(error)


def calculate(a: Int, operation: Operation, b: Int): Either[String, Double] =
  operation match
    case Add => Right(a + b)
    case Substruct => Right(a - b)
    case Multiply => Right(a * b)
    case Divide =>
      if b == 0 then Left("Cannot divide by zero!")
      else Right(a / b)
    case Power => Right(Math.pow(a, b))
