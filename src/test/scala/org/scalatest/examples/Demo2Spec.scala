
package org.scalatest.examples

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.examples.Demo._
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FunSpec, Matchers}

class Demo2Spec extends FunSpec with Matchers with PropertyChecks with TypeCheckedTripleEquals {

  describe("The squareRoot1 function") {
    it("should compute the square root") {
      forAll { (x: Double) =>
        whenever (x >= 0.0 && !x.isPosInfinity) {
          squareRoot1(x) should === (math.sqrt(x))
        }
      }
      forAll { (x: Double) =>
        whenever (x >= 0.0 && !x.isPosInfinity) {
          val result = squareRoot1(x)
          val tolerance = math.ulp(x)
          result * result should === (x +- tolerance)
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
