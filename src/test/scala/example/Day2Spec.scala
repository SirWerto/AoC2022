package example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day2Spec extends AnyFlatSpec with Matchers {
  "Day2.a" should "work" in {
    val input = "src/test/resources/day2TestInput.txt"
    Day2.a(input) shouldEqual 15
  }

  "Day2.b" should "work" in {
    val input = "src/test/resources/day2TestInput.txt"
    Day2.b(input) shouldEqual 12
  }

  // "Day2.b" should "work" in {
  //   val input = "src/test/resources/day2TestInput.txt"
  //   Day2.b(input) shouldEqual 45000
  // }
}
