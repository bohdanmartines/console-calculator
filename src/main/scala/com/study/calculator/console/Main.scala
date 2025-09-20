package com.study.calculator.console

import scala.annotation.tailrec
import scala.io.StdIn.readLine

val LinePrefix = "calc>"

@main def app(): Unit =
  println("Welcome to Console Calculator!")
  repl()

@tailrec
def repl(): Unit =
  println("Type the operation. Examples: 1 + 2 | 4 - 1 | 2 * 3 | 6 / 2")
  val input = readLine(LinePrefix)
  println(s"You entered [$input]")

  if input == null || input.equals(":q") then
    println("Bye!")
  else
    repl()