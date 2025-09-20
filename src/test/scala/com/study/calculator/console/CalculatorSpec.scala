package com.study.calculator.console

import com.study.calculator.console.Calculator.calculate
import org.scalatest.funsuite.AnyFunSuite

import scala.runtime.stdLibPatches.Predef.assert

class CalculatorSpec extends AnyFunSuite {

  test("calculate should return correct results for valid operations") {
    assert(calculate(3, Operation.Add, 2) == Right(5))
    assert(calculate(5, Operation.Subtruct, 3) == Right(2))
    assert(calculate(4, Operation.Multiply, 2) == Right(8))
    assert(calculate(8, Operation.Divide, 2) == Right(4))
    assert(calculate(2, Operation.Power, 3) == Right(8.0))
  }

  test("calculate should return Left when dividing by zero") {
    assert(calculate(10, Operation.Divide, 0) == Left("Cannot divide by zero!"))
  }

  test("calculate with invalid operation string should return Left with error message") {
    assert(Calculator.calculate(5, "%", 2) == Left("Unknown operation [%]"))
  }

  test("calculate should handle edge cases like negative numbers and large inputs") {
    assert(calculate(-2, Operation.Add, 3) == Right(1))
    assert(calculate(2, Operation.Subtruct, -3) == Right(5))
    assert(calculate(1000, Operation.Power, 0) == Right(1.0)) // x^0 = 1
  }
}
