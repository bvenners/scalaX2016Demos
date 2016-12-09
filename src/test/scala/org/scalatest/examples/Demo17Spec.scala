package org.scalatest.examples

// Type-constructor polymorphism

import org.scalactic.TypeCheckedTripleEquals
import org.scalactic.anyvals.PosZDouble
import org.scalatest.examples.Demo._
import org.scalatest.prop.PropertyChecks
import org.scalatest.{LogicFunSpec, WillMatchers}

// Demo 17 - use implies with q and q
class Demo17Spec extends LogicFunSpec with WillMatchers with PropertyChecks with TypeCheckedTripleEquals {

  describe("The squareRoot1 function") {
    it("should compute the square root") {
      forAll { (x: PosZDouble) =>
        val p = x will !== (PosZDouble.PositiveInfinity)
        val q = squareRoot3(x).value will === (math.sqrt(x))
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
