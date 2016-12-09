package org.scalatest.examples

// Type-constructor polymorphism

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.examples.Demo._
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FunSpec, Matchers}

// DEMO 2 - use assume with an ensuring that compares with math.sqrt
class Demo2Spec extends FunSpec with Matchers with PropertyChecks with TypeCheckedTripleEquals {

  describe("The squareRootB function") {
    it("should compute the square root") {
      forAll { (x: Double) =>
        whenever (x >= 0.0 && !x.isPosInfinity) {
          noException should be thrownBy { squareRootB(x) }
        }
      }
    }
    it("should should throw IAE on negative input") {
      an [AssertionError] should be thrownBy {
        squareRootB(-1.0)
      }
    }
    it("should should throw IAE on positive infinity input") {
      an [AssertionError] should be thrownBy {
        squareRootB(Double.PositiveInfinity)
      }
    }
  }
}
