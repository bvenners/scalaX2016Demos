package org.scalatest.examples

// Type-constructor polymorphism

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.examples.Demo._
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FunSpec, Matchers}

class Demo0Spec extends FunSpec with Matchers with PropertyChecks with TypeCheckedTripleEquals {

  describe("The squareRoot1 function") {
    it("should compute the square root with repetitive ensuring") {
      forAll { (x: Double) =>
        whenever (x >= 0.0 && !x.isPosInfinity) {
          noException should be thrownBy { squareRoot0(x) }
        }
      }
    }
    it("should compute the square root with attempt at smarter ensuring") {
      forAll { (x: Double) =>
        whenever (x >= 0.0 && !x.isPosInfinity) {
          noException should be thrownBy { squareRoot00(x) }
        }
      }
    }
    it("should should throw IAE on negative input") {
      an [IllegalArgumentException] should be thrownBy {
        squareRoot1(-1.0)
      }
    }
    it("should should throw IAE on positive infinity input") {
      an [IllegalArgumentException] should be thrownBy {
        squareRoot1(Double.PositiveInfinity)
      }
    }
  }
}
