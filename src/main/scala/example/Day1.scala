package example

import scala.language.postfixOps

object Day1{

  def mainA(): Int = {
    val inputFileName = "src/main/resources/day1Input.txt"
    a(inputFileName)
  }

  def a(inputFileName: String): Int = {
    Utils.seqFromFile(inputFileName)
    .foldLeft((0,0))(myFoldA)
    ._2
    }


  private def myFoldA(acc: Tuple2[Int, Int], x: String): Tuple2[Int, Int] = {
    val (current, max) = acc
    x match {
      case "" => (0, max)
      case i => {val newCurrent = current + i.toInt ; (newCurrent, Seq(newCurrent, max).max)}
    }
  }

  def a2(inputFileName: String): Any = {
    val elvesFromFile = Utils.seqFromFile _ andThen splitElves _
    elvesFromFile(inputFileName)
      .map(computeEnergy)
      .max
  }

  private def splitElves(lines: Seq[String]): Seq[Seq[String]] = {
    splitRec(Seq.empty[Seq[String]], lines)
  }

  private def splitRec(acc: Seq[Seq[String]], lines: Seq[String]): Seq[Seq[String]] = {
    val (elve, elves) = lines.span(_ != "")
    val elvesCleaned: Seq[String] = elves.drop(1)
    if (elve.isEmpty) return acc
    val newAcc = acc.appended(elve)
    splitRec(newAcc, elvesCleaned)
  }

  private def computeEnergy = (s: Seq[String]) => s.map(_.toInt).sum

  def b2(inputFileName: String): Int = {
    val elvesFromFile = Utils.seqFromFile _ andThen splitElves _

    elvesFromFile(inputFileName)
      .map(computeEnergy)
      .sortWith(_ > _)
      .take(3)
      .sum
  }



  def mainB(): Int = {
    val inputFileName = "src/main/resources/day1Input.txt"
    b(inputFileName)
  }

  def b(inputFileName: String): Int = {

    val elvesEnergies = (x: String) => Utils.seqFromFile(x)
    .foldLeft((0, Seq.empty[Int]))(myFoldB)

    val consumeTuple = (t: Tuple2[Int, Seq[Int]]) => t._2.appended(t._1)
    val sumMax3 = (x: Seq[Int]) => x.sortWith(_ > _).take(3).sum
    

    val b = sumMax3 compose consumeTuple compose elvesEnergies


    b(inputFileName)
    }

  private def myFoldB(acc: Tuple2[Int, Seq[Int]], x: String): Tuple2[Int, Seq[Int]] = {
    val (current, results) = acc
    x match {
      case "" => (0, {val newResults = results :+ (current) ; newResults})
      case i => (current + i.toInt, results)
    }
  }





}



