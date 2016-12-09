package org.scalatest.examples

// Type-constructor polymorphism

import java.io.FileWriter

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.examples.Demo._
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FunSpec, LogicFunSpec, Matchers}

// DEMO 8 - introducing LogicSpec
class Demo8Spec extends LogicFunSpec with Matchers with PropertyChecks with TypeCheckedTripleEquals {

  describe("The squareRoot1 function") {
    it("should compute the square root") {
      val two = squareRoot1(4.0)
      // Expression of type Unit doesn't conform to expected type scalatest.Assertion
      // val outputFile = new FileWriter("squareRoot.out")
      // try outputFile.write(two.toString + "\n")
      // finally outputFile.close()

      // intercept
      // expectMsg
      // println() or info()

      two shouldEqual 2.0
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
