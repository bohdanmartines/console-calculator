package com.study.calculator.console

import com.study.calculator.console.Operation.{Add, Divide, Multiply, Power, Subtruct}

object Calculator:

  def calculate(a: BigDecimal, operation: String, b: BigDecimal): Either[String, BigDecimal] =
    Operation.fromString(operation) match
      case Right(value) => calculate(a, value, b)
      case Left(error) => Left(error)

  def calculate(a: BigDecimal, operation: Operation, b: BigDecimal): Either[String, BigDecimal] =
    operation match
      case Add => Right(a + b)
      case Subtruct => Right(a - b)
      case Multiply => Right(a * b)
      case Divide =>
        if b == 0 then Left("Cannot divide by zero!")
        else Right(a / b)
      case Power =>
        if b.isValidInt then
          Right(a.pow(b.toInt))
        else
          Left("Please enter an integer exponent!")

