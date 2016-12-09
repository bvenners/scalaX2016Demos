package org.scalatest.examples

// Type-constructor polymorphism

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.examples.Demo._
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FunSpec, Matchers}

// DEMO 3 - use require with ensuring
class Demo3Spec extends FunSpec with Matchers with PropertyChecks with TypeCheckedTripleEquals {

  describe("The squareRootC function") {
    it("should compute the square root") {
      forAll { (x: Double) =>
        whenever (x >= 0.0 && !x.isPosInfinity) {
          noException should be thrownBy { squareRootC(x) }
        }
      }
    }
    it("should should throw IAE on negative input") {
      an [IllegalArgumentException] should be thrownBy {
        squareRootC(-1.0)
      }
    }
    it("should should throw IAE on positive infinity input") {
      an [IllegalArgumentException] should be thrownBy {
        squareRootC(Double.PositiveInfinity)
      }
    }
  }
}
