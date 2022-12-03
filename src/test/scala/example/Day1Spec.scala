package example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day1Spec extends AnyFlatSpec with Matchers {
  "Day1.a" should "work" in {
    val input = "src/test/resources/day1TestInput.txt"
    Day1.a(input) shouldEqual 24000
  }

  "Day1.a2" should "work" in {
    val input = "src/test/resources/day1TestInput.txt"
    Day1.a2(input) shouldEqual 24000
  }

  "Day1.b" should "work" in {
    val input = "src/test/resources/day1TestInput.txt"
    Day1.b(input) shouldEqual 45000
  }


  "Day1.b2" should "work" in {
    val input = "src/test/resources/day1TestInput.txt"
    Day1.b2(input) shouldEqual 45000
  }



}
