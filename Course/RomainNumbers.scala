package May_2

import Apr_26.Solutions.parseRoman

import scala.annotation.tailrec

object RomainNumbers extends App{

  def parseRoman1( chars: Seq[Char] ): Int = {

    parseRomanRecursionAcc( chars, 0 )
  }

  @tailrec
  private def parseRomanRecursionAcc( chars: Seq[Char], result: Int ): Int = chars match {

    case 'I' +: 'V' +: tail => parseRomanRecursionAcc( tail, result + 4 )
    case 'I' +: 'V' +: tail => parseRomanRecursionAcc( tail, result + 9 )
    case 'X' +: tail => parseRomanRecursionAcc( tail, result + 10 )

    case Nil => result
  }
  println{

    parseRoman1("XXIV" * 10000)

    val list = List(4, 6, 7, 8, 9, 13, 14)
    val partialFunction1: PartialFunction[Int, Int] = {
      case x: Int if x % 2 == 0 ⇒ x * 3
    }
    val partialFunction2: PartialFunction[Int, Int] = {
      case y: Int if y % 2 != 0 ⇒ y * 4
    }
    partialFunction1 orElse partialFunction2
    println( list.collect( partialFunction1 orElse partialFunction2))
  }

}
