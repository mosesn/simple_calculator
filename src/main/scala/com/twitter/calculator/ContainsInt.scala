package com.twitter.calculator

object ContainsInt {
  def unapply(x: String): Option[Int] = try {
    Some(x.toInt)
  } catch {
    case _: NumberFormatException => None
  }
}

object ContainsPlus {
  def unapply(x: String): Option[Plus.type] = {
    if (x == "+") {
      Some(Plus)
    } else {
      None
    }
  }
}
