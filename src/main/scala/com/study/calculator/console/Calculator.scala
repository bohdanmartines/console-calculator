package com.study.calculator.console

import com.study.calculator.console.Operation.{Add, Divide, Multiply, Power, Subtruct}

object Calculator:

  def calculate(a: Int, operation: String, b: Int): Either[String, Double] =
    Operation.fromString(operation) match
      case Right(value) => calculate(a, value, b)
      case Left(error) => Left(error)

  def calculate(a: Int, operation: Operation, b: Int): Either[String, Double] =
    operation match
      case Add => Right(a + b)
      case Subtruct => Right(a - b)
      case Multiply => Right(a * b)
      case Divide =>
        if b == 0 then Left("Cannot divide by zero!")
        else Right(a / b)
      case Power => Right(Math.pow(a, b))

