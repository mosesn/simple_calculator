package com.twitter.calculator

abstract class Operator(value: String) {
  def apply(lhs: Int, rhs: Int): Int
  def unapply(str: String): Option[(Int, Int) => Int] =
    if (str == value) Some(this.apply) else None
}

object Operator {
  def unapply(x: String): Option[(Int, Int) => Int] = {
    Seq(Plus, Minus, Times, Divide) find (_.unapply(x).isDefined) map (_.apply)
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
