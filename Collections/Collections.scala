package s4j.scala.chapter03

object Collections extends App {

  val list = List("a", "b", "c")

  val map = Map(1 -> "a", 2 -> "b")

  // version 1 (tuples)
  map foreach (x => println (x._1 + "-->" + x._2))

  // version 2 (foreach and case)
  map foreach {case (key, value) => println (key + "-->" + value)}

  map.foreach(  value => println(value))

  map.keys.foreach( key => println( key ))

  var similarItems = ""
  map.keys.foreach( (movie) =>
    if ( map.contains(movie)) similarItems += (movie -> true)
  )
  map foreach ( (movie) =>
    if (map.contains(movie._1)) similarItems += (movie._1 -> true)
    )
  for ((movie1, rating1) <- map ) {
    if ( map.contains(movie1)) similarItems += (movie1 -> true)
  }
  // import scala.collection.JavaConversions._  to add java map functions

  list.foreach( value => println(value))

  // short hand version (similar to method reference in Java)
  list.foreach(println)


  // different ways to process a list with a 'for' loop

  for (value <- list) println(value)

  for (value <- list.reverse) println(value)

  for (value <- list) {
    println(value)
  }

  (0 to 100).foreach(println(_))
  
    val list: List[Int] = List( 1, 2, 0, 3, 4 )
  val result = new ListSplit().splitBySeparator( list, 0 )
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

}

