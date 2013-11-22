package com.twitter.calculator

import java.util.Stack

object Driver {
  def main(args: Array[String]) {
    val stack = new Stack[Int]()
    for (either <- args map parseArg) {
      either match {
        case Left(num) => stack.push(num)
        case Right(operator) => stack.push(operator(stack.pop(), stack.pop))
      }
    }

    val result = if (stack.empty) {
      throw new Exception("why is your stack empty")
    } else {
      stack.pop()
    }
    if (!stack.empty) {
      throw new Exception("why is your stack not empty?")
    } else {
      println(result)
    }
  }

  def parseArg(arg: String): Either[Int, (Int, Int) => Int] = arg match {
    case Operand(num) => Left(num)
    case Operator(fn) => Right(fn)
  }
}
