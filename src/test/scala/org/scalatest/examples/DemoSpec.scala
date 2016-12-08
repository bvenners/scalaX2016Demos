
package org.scalatest.examples

import org.scalatest.LogicFunSpec
import org.scalatest.WillMatchers
import org.scalactic.anyvals.PosZDouble
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.prop.PropertyChecks
import Demo._

class DemoSpec extends LogicFunSpec with WillMatchers with PropertyChecks with TypeCheckedTripleEquals {

  describe("The squareRoot function") {
/*
    it("should compute the square root") {
      forAll { (x: PosZDouble) => 
        (x.isPosInfinity willBe false) implies {
          val result = squareRoot(x)
          result * result willEqual x.value +- tolerance
        }
      }
    }
    it("should compute the square root with a test that uses assertions") {
      forAll { (x: PosZDouble) => 
        whenever(!x.isPosInfinity) {
          val result = squareRoot(x)
          assert(result.value == math.sqrt(result))
        }
      }
    }
*/
    it("should mind its ps and qs") {
      forAll (minSuccessful(10000)) { (x: PosZDouble) =>
        val p = {
          x will !== (PosZDouble.PositiveInfinity)
        }
        val q = {
          val result = squareRoot(x)
          val tolerance = math.ulp(x)
          (result * result will === (x.value +- tolerance)) && 
          (result.value will === (math.sqrt(x)))
        }
        p implies q
      }
    }
/*
    it("should treat vacuous yes as a discarded evaluation") {
      forAll { (x: PosZDouble) => 
        val p = expect(false)
        val q = {
          val result = squareRoot(x)
          result * result willEqual x.value +- tolerance
        }
        p implies q
      }
    }
*/
  }
}
