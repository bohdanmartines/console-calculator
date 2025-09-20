package com.study.calculator.console

enum Operation:
  case Add, Substruct, Multiply, Divide, Power

object Operation:
  def fromString(input: String): Either[String, Operation] =
    input match
      case "+" => Right(Add)
      case "-" => Right(Substruct)
      case "*" => Right(Multiply)
      case "/" => Right(Divide)
      case "^" => Right(Power)
      case other => Left(s"Unknown operation [$other]")