package com.study.calculator.console

enum Operation:
  case Add, Substruct, Multiply, Divide, Power

object Operation:
  def parse(input: String): Either[String, Operation] = {
    input match
      case "+" => Right(Add)
      case "-" => Right(Substruct)
      case "*" => Right(Multiply)
      case "/" => Right(Divide)
      case "^" => Right(Power)
      case _ => Left(s"Unrecognized operation $input")
  }