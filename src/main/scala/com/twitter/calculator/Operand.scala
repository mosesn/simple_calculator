package com.twitter.calculator

case class Operand(num: Int)

object Operand {
  def unapply(x: String): Option[Int] = try {
    Some(x.toInt)
  } catch {
    case _: NumberFormatException => None
  }
}
