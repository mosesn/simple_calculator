package com.twitter.calculator

object ContainsInt {
  def unapply(x: String): Option[Int] = try {
    Some(x.toInt)
  } catch {
    case _: NumberFormatException => None
  }
}

object ContainsPlus {
  def unapply(x: String): Option[Operator] = x match {
    case "+" => Some(Plus)
    case "-" => Some(Minus)
    case "*" => Some(Times)
    case "/" => Some(Divide)
    case _   => None
  }
}
