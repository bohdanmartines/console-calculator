package com.study.calculator.console

import org.scalatest.funsuite.AnyFunSuite

class OperationSpec extends AnyFunSuite:

  // Test the 'Operation.fromString'
  test("Operation.fromString should correctly map valid symbols to operations"):
    assert(Operation.fromString("+") == Right(Operation.Add))
    assert(Operation.fromString("-") == Right(Operation.Subtruct))
    assert(Operation.fromString("*") == Right(Operation.Multiply))
    assert(Operation.fromString("/") == Right(Operation.Divide))
    assert(Operation.fromString("^") == Right(Operation.Power))

  test("Operation.fromString should return Left for invalid symbols"):
    assert(Operation.fromString("%") == Left("Unknown operation [%]"))
    assert(Operation.fromString("invalid") == Left("Unknown operation [invalid]"))
