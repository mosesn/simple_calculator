package com.twitter.calculator

trait Token

case class Operand(num: Int) extends Token

case object Plus extends Token
