

import collection.mutable.ListBuffer

class ListSplit {

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

/*  def splitBySeparatorFoldLeft[T]( list: List[T], sep: T ): List[List[T]] = {

    list.foldLeft( List( List[String]() )) (
      ( resultList, member ) => member match {
        case c if( ( c == sep ) && ( !resultList.last.isEmpty  )) => (List(List.empty ))
        //case c => resultList.last +=`member`
      }

    ).map( _.toSeq )

  }

}*/

object ListSplit extends App {

  val list: List[Int] = List( 1, 2, 0, 3, 4 )
  val result = new ListSplit().splitBySeparator( list, 0 )
 // val result1 = new ListSplit().splitBySeparatorFoldLeft( list, 0 )
  println( result )

  var goats = List(2, 4)

  def cube[Int]( list: Seq[Int] ) = {

    for ( x <- goats ) yield Math.pow( x, 3 )
  }

  println( cube( list ) )
  var names = List("tuco", "jesse", "hank", "gustavo")

  var acc = 0
  names.foreach( current => (
      if( current.length > acc ){
        acc = current.length
      })
  )
  println( acc )

  var letters = List("g", "o", "a", "t")

  println {
    letters.foldLeft("") { ( memo: String, num: String ) =>
      memo + num
    }
  }
  var huh = List("l", "o", "o", "c")
  println {
    huh.foldRight("") { ( memo: String, num: String ) =>
      memo + num
    }
  }

  var countries = List("brazil", "argentina", "colombia")
  println {
    countries.reduceLeft { (s1: String, s2: String) =>
      s"$s1,$s2"
    }
  }
  var me = List("i", "am", "quiet")
  println {
    me.map { (word: String) =>
      word.toUpperCase
    }
  }
  var whatever = List(1, 2, 3, 4, 5, 6, 7)
  println {
    whatever.foldLeft( 0 ) { ( memo: Int, num: Int ) =>
      if( num % 2 == 0 ) memo + num else memo
    }
  }

  var rrr = List("ant", "beer", "battered", "cool", "burger")

  println{

    rrr.filter{ ( current : String ) =>

      current.take(1) == "b"
    }.reduceLeft{( s1: String, s2: String ) =>

      s"$s1 $s2"
    }
  }




}}
