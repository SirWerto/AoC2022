package example

object Day2{

  def mainA(): Int = {
    val input = "src/main/resources/day2Input.txt"
    a(input)
  }

  def mainB(): Int = {
    val input = "src/main/resources/day2Input.txt"
    b(input)
  }

  def a(inputFileName: String): Int = {
    val computeResult = (s: String) => {val Array(opponent, me) = s.split(" ").map(wordToPlay) ; computeScore(opponent, me)}
    Utils.seqFromFile(inputFileName)
      .map(computeResult)
      .sum
    }

  def b(inputFileName: String): Int = {
    val computeResult = (s: String) => {val (opponent: String, me: String) = wordsToPlay(s.split(" ")) ; computeScore(opponent, me)}
    Utils.seqFromFile(inputFileName)
      .map(computeResult)
      .sum
    }


   private def wordToPlay(playEncode: String): String = playEncode match {
    case "A" => "Rock"
    case "X" => "Rock"
    case "B" => "Paper"
    case "Y" => "Paper"
    case "C" => "Scissors"
    case "Z" => "Scissors"
   }

   private def wordsToPlay(playsEncoded: Array[String]): Tuple2[String, String] = {
     val Array(opponent, resolution) = playsEncoded
     val opponentPlay = wordToPlay(opponent)
     resolution match {
       case "X" => (opponentPlay, losingPlay(opponentPlay))
       case "Y" => (opponentPlay, opponentPlay)
       case "Z" => (opponentPlay, winningPlay(opponentPlay))
     }
   }

  private def winningPlay(play: String): String = play match {
    case "Rock" => "Paper"
    case "Paper" => "Scissors"
    case "Scissors" => "Rock"
  }

  private def losingPlay(play: String): String = play match {
    case "Rock" => "Scissors"
    case "Paper" => "Rock"
    case "Scissors" => "Paper"
  }

  private def computeScore(opponent: String, me: String): Int = {
    playPoints(me) + outcome(me, opponent)
  }

  private def playPoints(play: String): Int = play match {
    case "Rock" => 1
    case "Paper" => 2
    case "Scissors" => 3
  }

  private def outcome(play1: String, play2: String): Int = (play1, play2) match {
    case ("Rock", "Rock") => 3
    case ("Rock", "Paper") => 0
    case ("Rock", "Scissors") => 6
    case ("Paper", "Rock") => 6
    case ("Paper", "Paper") => 3
    case ("Paper", "Scissors") => 0
    case ("Scissors", "Rock") => 0
    case ("Scissors", "Paper") => 6
    case ("Scissors", "Scissors") => 3
  }

}
