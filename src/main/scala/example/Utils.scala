package example


object Utils{

  def source(inputFileName: String): String = {
    scala.io.Source.fromFile(inputFileName).toString
  }

  def seqFromFile(inputFileName: String): Seq[String] = {
    scala.io.Source.fromFile(inputFileName).getLines.toSeq
  }
}
