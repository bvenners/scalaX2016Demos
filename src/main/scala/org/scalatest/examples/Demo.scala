package org.scalatest.examples

import org.scalactic.anyvals.PosZDouble

object Demo {

  // Uses assume, ensuring, and ulp
  def squareRootA(x: Double): Double = {
    assume(x >= 0.0 && !x.isPosInfinity)
    math.sqrt(x) ensuring { res =>
      val tolerance = math.ulp(x) // Unit in the last place
      (res * res - x).abs <= tolerance
    }
  }








  // Uses assume, ensuring, and math.sqrt
  def squareRootB(x: Double): Double = {
    assume(x >= 0.0 && !x.isPosInfinity)
    math.sqrt(x) ensuring { res =>
      res == math.sqrt(x)
    }
  }









  // Uses require, ensuring, and math.sqrt
  def squareRootC(x: Double): Double = {
    require(x >= 0.0 && !x.isPosInfinity)
    math.sqrt(x) ensuring { res =>
      res == math.sqrt(x)
    }
  }









  // Uses require, but no ensuring
  def squareRoot1(x: Double): Double = {
    require(x >= 0.0 && !x.isPosInfinity)
    math.sqrt(x)
  }









  // Uses PosZDouble and require, but no ensuring
  def squareRoot2(x: PosZDouble): Double = {
    require(!x.isPosInfinity)
    math.sqrt(x)
  }









  // Uses PosZDouble and require, no ensuring, but returns PosZDouble
  def squareRoot3(x: PosZDouble): PosZDouble = {
    require(!x.isPosInfinity)
    val result = math.sqrt(x)
    // PosZDouble(result)
    // PosZDouble.from(result).get
    PosZDouble.ensuringValid(result)
  }
}
