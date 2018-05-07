package Apr_26

import May_2.RomainNumbers.parseRoman1

import scala.annotation.tailrec
import scala.collection.immutable.HashMap
import scala.collection.mutable.ListBuffer

class Solutions {

  val message = "I will not use mutable variables"
  repeat(10)(() => {
    println(message)
  })
  repeat(100) { () => println("test")
  }

  def repeat2(times: Int): (() => Unit) => Unit = {
    (f: () => ()) => for (_ <- 1 to times) f()
  }

  def repeat(times: Int)(f: () => Unit): Unit = {
    for (_ <- 1 to times) f()
  }

  def repeat3(times: Int): (() => Unit) => Unit = {
    f => for (_ <- 1 to times) f()
  }

  val repeat10: (() => Unit) => Unit = repeat(10)(_)
  repeat10 { () => println(message)}

  // -----------------------------------------------------------

  def splitBySeparator[T]( list: Seq[T], sep: T ): Seq[Seq[T]] = {

    val result = ListBuffer( ListBuffer[T]() )
    list foreach { e =>
      if ( e == sep ) {
        if  ( !result.last.isEmpty ) {

          result += new ListBuffer[T]()
        }

      } else{
        result.last += e
      }
    }
    result.map(_.toSeq)
  }
}

object Solutions extends App{

  var solutions = new Solutions
/**
  * Traversable
  * val msgs : Traversable[String] = Traversable("Java", "Scala", "Bad", "Good")
  * val prefixes: Traversable[String] = Traversable("Ja", "B")
  * // results should contain all msgs that DONT start with any from prefixes. (in our example Scala Good)
  * val results: Traversable[String] = ???
  */
  val  prefixes:  Traversable[String]  =  Traversable("Ja",  "B")
  val  msgs  :  Traversable[String]  =  Traversable("Java",  "Scala",  "Bad",  "Good")

  println{

    msgs.filter( w => prefixes.forall( p => !w.startsWith( p )))
  }
  /**
    * split list of int to lists, giving an int delimiter
    *
    * [1, 2, 0, 3, 4] , 0 => [[1, 2] , [3, 4]]
    */
  val numbers: List[Int] = List( 1, 2, 0, 3, 4 )
  println( solutions.splitBySeparator( numbers, 0 ) )

  /**
    * Roman numbers
    *
    * def parseRoman(chars: Seq[Char]): Int = ???
    *
    * according to the rules:
    * I --- 1
    * V --- 5
    * X --- 10
    * IV --- 4
    * IX --- 9
    *
    * e.g.:
    * parseRoman("XXIV") should return 24
     */
  val mapped = HashMap[String, Int](
    "I"->1, "II"->2, "III"->3, "IV"->4, "V"->5, "VI"->6, "VII"->7, "VIII"->8, "IX"->9, "X"->10
  )
  val ones = List("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX");
  val tens = List("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC");
  
  def parseRoman( chars: Seq[Char]): Int = {
    chars.foldLeft(0){ ( memo: Int, char: Char )=>
      if( mapped.contains( char.toString )) memo + mapped.get( char.toString ).getOrElse( 0 ) else memo
    }
  }
  println( parseRoman("XXIV") )

  def parseRomanRecursion( chars: Seq[Char] ): Int ={

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
  }

  var result = parseRomanRecursion("XXIV")
  println( result )

/*
https://projecteuler.net/problem=9
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.
There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 */
  def eulerNumbers( min: Int, max: Int, expected: Int ) = {
    for {
      x <- min to max - 2
      y <- x until max
      target = x*x + y*y
      z = expected - x - y
      _ = if( z % 100 == 0 ) println( z ) else None
      if( target == expected )
    } println(x, y, z)
  }
  eulerNumbers( 1, 1000, 1000  )

  val oneToTen = 1 to 10

  // Traversable length

  def  length[A]( l:  List[A]): Int = {
    l.foldLeft( 0 ) (( acc, _ ) => acc + 1 )
  }
  // Traversable map
  def  map[A,  B](fa:  List[A])(f:  A  =>  B):  List[B] = {
    fa.foldLeft( List.empty[B] )(
      ( resultList, member ) => resultList :+ f(member)
    )
  }
  map( List(1,2,3))( _ * 2 )

  // Traversable filter
  def  filter[A](fa: List[A])( f: A  =>  Boolean): List[A] = {
    fa.foldLeft( List.empty[A])(
      ( resultList, member ) =>
        if( f( member ) )
          resultList :+ member
        else resultList
    )
  }

  //  Fibonachi

  def fib2: Stream[Long] = {
    0L #:: 1L #:: fib2.zip( fib2.tail ).map( x => x._1 + x._2 )
  }
  fib2 take 20 foreach println
}


