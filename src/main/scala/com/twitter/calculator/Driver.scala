package com.twitter.calculator

import java.util.Stack

object Driver {
  def main(args: Array[String]) {
    val list = parseArgs(args)
    val stack = new Stack[Int]()
    for (token <- list) {
      if (token.isInstanceOf[Operand]) {
        stack.push(token.asInstanceOf[Operand].num)
      } else {
        stack.push(stack.pop() + stack.pop())
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

  def parseArgs(args: Array[String]): List[Token] = {
    for (arg <- args.toList)
      yield {
        val num = fancyToInt(arg)
        if (num.isDefined) {
          Operand(num.get)
        } else {
          Plus
        }
      }
  }

  def fancyToInt(arg: String): Option[Int] =
    try {
      Some(arg.toInt)
    } catch {
      case _: NumberFormatException => None
    }
}
