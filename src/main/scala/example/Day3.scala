package example

object Day3{

  def mainA(): Int = {
    val input = "src/main/resources/day3Input.txt"
    a(input)
  }

  def mainB(): Int = {
    val input = "src/main/resources/day3Input.txt"
    b(input)
  }

  def a(inputFileName: String): Int = {
    // val f = charValue _ compose findDuplicatedItem _ compose splitInHalf _ 
    val f = splitInHalf _ andThen findDuplicatedItem _ andThen charValue _
    Utils.seqFromFile(inputFileName)
    .map(f)
    .sum
    }

  def b(inputFileName: String): Int = {
    val f = charValue _ compose findBadge _
    Utils.seqFromFile(inputFileName)
    .grouped(3)
    .toSeq
    .map(f)
    .sum
    }


  private def splitInHalf(line: String): Seq[String] = {
    val (t1, t2) = line.splitAt(line.length/2)
    Seq(t1, t2)
  }

  private def findDuplicatedItem(compartments: Seq[String]): Char = {
    val Seq(c1, c2) = compartments.map(_.toArray.toSet)
    (c1 & c2).head
  }

  private def findBadge(elves: Seq[String]): Char = {
    elves.map(_.toArray.toSet)
    .reduce(_ & _)
    .head
  }

  private def charValue(c: Char): Int = {
    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexWhere(_ == c) + 1
  }
}
