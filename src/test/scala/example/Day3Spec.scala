package example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day3Spec extends AnyFlatSpec with Matchers {
  "Day3.a" should "work" in {
    val input = "src/test/resources/day3TestInput.txt"
    Day3.a(input) shouldEqual 157
  }

  "Day3.b" should "work" in {
    val input = "src/test/resources/day3TestInput.txt"
    Day3.b(input) shouldEqual 70
  }
}
