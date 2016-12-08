package org.scalatest.examples

// Type-constructor polymorphism

import org.scalactic.TypeCheckedTripleEquals
import org.scalactic.anyvals.PosZDouble
import org.scalatest.examples.Demo._
import org.scalatest.prop.PropertyChecks
import org.scalatest.{Expectation, Fact, LogicFunSpec, WillMatchers}

// What is a H-O fun arg types of 5307 overloaded methods
// use implies with q and q
class Demo12Spec extends LogicFunSpec with WillMatchers with PropertyChecks with TypeCheckedTripleEquals {

  describe("The squareRoot1 function") {
    it("should compute the square root") {
      forAll { (x: PosZDouble) =>
        x != PosZDouble.PositiveInfinity implies squareRoot3(x).value == math.sqrt(x)
      }
    }
    it("should compute the square root (version 2)") {
      forAll { (x: PosZDouble) =>
        val p: Fact = x != PosZDouble.PositiveInfinity
        val q: Fact = squareRoot3(x).value == math.sqrt(x)
        p implies q
      }
    }
    it("should should throw IAE on negative input") {
      an [IllegalArgumentException] will be thrownBy {
        squareRoot1(-1.0)
      }
    }
    it("should should throw IAE on positive infinity input") {
      an [IllegalArgumentException] will be thrownBy {
        squareRoot1(Double.PositiveInfinity)
      }
    }
  }
}
