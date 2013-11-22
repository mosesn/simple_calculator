package com.twitter.calculator

trait Token

case class Operand(num: Int) extends Token

trait Operator extends Token {
  def apply(lhs: Int, rhs: Int): Int
}

object Plus extends Operator {
  def apply(lhs: Int, rhs: Int): Int = lhs + rhs
}
object Minus extends Operator {
  def apply(lhs: Int, rhs: Int): Int = lhs - rhs
}
object Times extends Operator {
  def apply(lhs: Int, rhs: Int): Int = lhs * rhs
}
object Divide extends Operator {
  def apply(lhs: Int, rhs: Int): Int = lhs / rhs
}
