package example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day4Spec extends AnyFlatSpec with Matchers {
  "Day4.a" should "work" in {
    val input = "src/test/resources/day4TestInput.txt"
    Day4.a(input) shouldEqual 2
  }

  "Day4.b" should "work" in {
    val input = "src/test/resources/day4TestInput.txt"
    Day4.b(input) shouldEqual 4
  }
}
