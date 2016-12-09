package org.scalatest.examples

// Type-constructor polymorphism

import java.io.{File, FileWriter}

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.examples.Demo._
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FunSpec, Matchers}

// (Demo 6 was REPL demo of Assertion and Succeeded)

// DEMO 7 File output
class Demo7Spec extends FunSpec with Matchers with PropertyChecks with TypeCheckedTripleEquals {

  describe("The squareRoot1 function") {
    it("should compute the square root") {
      val two = squareRoot1(4.0)
      val outputFile = new FileWriter("squareRoot.out")
      try outputFile.write(two.toString + "\n")
      finally outputFile.close()
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
