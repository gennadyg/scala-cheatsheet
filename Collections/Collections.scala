/*
 * Copyright (c) 2015-2017 Gennady Gilin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

}

