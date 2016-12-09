package org.scalatest.examples

// Type-constructor polymorphism

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.examples.Demo._
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FunSpec, Matchers}

// DEMO 1 - use assume with an ensuring that uses ULP and a tolerance
class Demo1Spec extends FunSpec with Matchers with PropertyChecks with TypeCheckedTripleEquals {

  describe("The squareRootA function") {
    it("should compute the square root") {
      forAll { (x: Double) =>
        whenever (x >= 0.0 && !x.isPosInfinity) {
          noException should be thrownBy { squareRootA(x) }
        }
      }
    }
    it("should should throw IAE on negative input") {
      an [AssertionError] should be thrownBy {
        squareRootA(-1.0)
      }
    }
    it("should should throw IAE on positive infinity input") {
      an [AssertionError] should be thrownBy {
        squareRootA(Double.PositiveInfinity)
      }
    }
  }
}
