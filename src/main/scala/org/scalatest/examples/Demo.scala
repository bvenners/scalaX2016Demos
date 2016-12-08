package org.scalatest.examples

import org.scalactic.anyvals.PosZDouble

object Demo {

  def squareRoot1(x: Double): Double = {
    require(x >= 0.0 && !x.isPosInfinity)
    math.sqrt(x)
  }

  def squareRoot2(x: PosZDouble): Double = {
    require(!x.isPosInfinity)
    math.sqrt(x)
  }

  def squareRoot3(x: PosZDouble): PosZDouble = {
    require(!x.isPosInfinity)
    val result = math.sqrt(x)
    // PosZDouble(result)
    // PosZDouble.from(result).get
    PosZDouble.ensuringValid(result)
  }

  def squareRoot(x: PosZDouble): PosZDouble = {
    require(!x.isPosInfinity)
    val result = math.sqrt(x)
    PosZDouble.ensuringValid(result)
  }
}
