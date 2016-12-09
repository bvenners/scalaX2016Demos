package org.scalatest.examples

// Type-constructor polymorphism

import org.scalactic.TypeCheckedTripleEquals
import org.scalactic.anyvals.PosZDouble
import org.scalatest.{FunSpec, LogicFunSpec, Matchers, WillMatchers}
import org.scalatest.examples.Demo._
import org.scalatest.prop.PropertyChecks

// DEMO 4 - an example based test
class Demo4Spec extends FunSpec with Matchers with PropertyChecks with TypeCheckedTripleEquals {

  describe("The squareRoot1 function") {
    it("should compute the square root") {
      val one = squareRoot1(1.0)
      one shouldEqual 1.0
      val two = squareRoot1(4.0)
      two shouldEqual 2.0
      val three = squareRoot1(9.0)
      three shouldEqual 3.0
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
