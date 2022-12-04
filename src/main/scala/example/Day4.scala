package example

object Day4{

  def mainA(): Int = {
    val input = "src/main/resources/day4Input.txt"
    a(input)
  }

  def mainB(): Int = {
    val input = "src/main/resources/day4Input.txt"
    b(input)
  }

  def a(inputFileName: String): Int = {
    val createSets = (s: Seq[String]) => s.map(setFromSection)
    val f = isPairCompletelyOverlapped _ compose createSets compose splitInSections _ 
    Utils.seqFromFile(inputFileName)
    .map(f)
    .foldLeft(0)((acc, x) => if (x) acc + 1 else acc)
    }

  def b(inputFileName: String): Int = {
    val createSets = (s: Seq[String]) => s.map(setFromSection)
    val f = isPairOverlapped _ compose createSets compose splitInSections _ 
    Utils.seqFromFile(inputFileName)
    .map(f)
    .foldLeft(0)((acc, x) => if (x) acc + 1 else acc)
    }

  private def splitInSections(line: String): Seq[String] = {
    line.split(",").toSeq
  }

  private def setFromSection(section: String): Set[Int] = {
    val Array(startPos, endPos) = section.split("-").map(_.toInt)
    Range(startPos, endPos+1, 1).toSet
  }

  private def isPairOverlapped(sets: Seq[Set[Int]]): Boolean = {
    val Seq(set1, set2) = sets
    (set1 & set2) != Set.empty
  }

  private def isPairCompletelyOverlapped(sets: Seq[Set[Int]]): Boolean = {
    val Seq(set1, set2) = sets
    completelyOverlap(set1, set2) || completelyOverlap(set2, set1)
  }
  private def completelyOverlap(set1: Set[Int], set2: Set[Int]): Boolean = {
    (set1 & set2) == set2
  }

}
