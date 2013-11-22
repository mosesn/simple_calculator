package com.twitter.calculator

import java.util.Stack

object Driver {
  def main(args: Array[String]) {
    println(evaluate(args))
  }

  def stackify(args: Array[String]): List[Int] = {
    val eithers = args map parseArg
    recursiveStackify(eithers, Nil)
  }

  type Token = Either[Int, (Int, Int) => Int]

  def recursiveStackify(args: Array[Token], stack: List[Int]): List[Int] = {
    if (args.isEmpty)
      stack
    else {
      val stk = args.head match {
        case Left(num) => num :: stack
        case Right(operator) =>
          operator(stack.head, stack.tail.head) :: stack.tail.tail
      }
      recursiveStackify(args.tail, stk)
    }
  }

  def evaluate(args: Array[String]): Int = {
    stackify(args) match {
      case x :: Nil => x
      case _ => throw new Exception("stack did not have one element")
    }
  }

  def parseArg(arg: String): Token = arg match {
    case Operand(num) => Left(num)
    case Operator(fn) => Right(fn)
  }
}
