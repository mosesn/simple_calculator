package com.twitter.calculator

import java.util.Stack

object Driver {
  type Token = Either[Int, (Int, Int) => Int]

  def main(args: Array[String]) {
    println(evaluate(args.toList))
  }

  def stackify(args: List[String]): List[Int] = {
    val eithers = args map parseArg
    eithers.foldLeft[List[Int]](Nil)(process)
  }

  def process(stack: List[Int], token: Token): List[Int] = token match {
    case Left(num) => num :: stack
    case Right(operator) => stack match {
      case x :: y :: tail => operator(x, y) :: tail
      case _ => throw new Exception("explode")
    }
  }

  def evaluate(args: List[String]): Int = stackify(args) match {
    case x :: Nil => x
    case _ => throw new Exception("stack did not have one element")
  }

  def parseArg(arg: String): Token = arg match {
    case Operand(num) => Left(num)
    case Operator(fn) => Right(fn)
  }
}
