package com.twitter.calculator

abstract class Operator(value: String) {
  def apply(lhs: Int, rhs: Int): Int
  def unapply(str: String): Option[Operator] =
    if (str == value) Some(this) else None
}

object Operator {
  def unapply(x: String): Option[(Int, Int) => Int] = x match {
    case Plus(operator) => Some(operator.apply)
    case Minus(operator) => Some(operator.apply)
    case Times(operator) => Some(operator.apply)
    case Divide(operator) => Some(operator.apply)
    case _   => None
  }
}

case object Plus extends Operator("+") {
  def apply(lhs: Int, rhs: Int): Int = lhs + rhs
}
case object Minus extends Operator("-") {
  def apply(lhs: Int, rhs: Int): Int = lhs - rhs
}
case object Times extends Operator("*") {
  def apply(lhs: Int, rhs: Int): Int = lhs * rhs
}
case object Divide extends Operator("/") {
  def apply(lhs: Int, rhs: Int): Int = lhs / rhs
}
