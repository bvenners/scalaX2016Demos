package org.scalatest.examples

// Type-constructor polymorphism

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.examples.Demo._
import org.scalatest.prop.PropertyChecks
import org.scalatest.{LogicFunSpec, Matchers}

// DEMO 9 - Our forAll in a LogicSpec
class Demo9Spec extends LogicFunSpec with Matchers with PropertyChecks with TypeCheckedTripleEquals {

  describe("The squareRoot1 function") {
    it("should compute the square root") {
      forAll { (x: Double) =>
        whenever (x >= 0.0 && !x.isPosInfinity) {
          squareRoot1(x) should === (math.sqrt(x))
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
