# Scala Notes 

## Quotes
Spans across multiple lines and don’t support escape sequences (using triple double-quotes).
``` scala
val myFile =
"""C:\Users\Shimi\Literals.scala"""
```
## Auxiliary Constructors:
``` scala
class Person (val name : String, var age : Int) {
	def this(name: String, birthDay : Date) {
		this(name, new Date().getYear - birthDay.getYear)
	}
	// assigning the default value for the type 
	var stage : Int = _ 
        // not specifying a value makes the field abstract.
	//In Scala in order to override a method you must use the override keyword
	override def toString = "Game at stage " + stage
	//Varargs in Scala are declared with the ‘*’ sign.
	def sumAll(numbers : Int*)
	// only visible to current instance
	private[this] val secret = "password"
	// only visible in package util
	private[util] val shared = "s1"
}
```
## Visibility Rules
- By default, everything in Scala is public.
- You can define a member/method/constructor/class as protected/private.
- A protected member is visible only to the inheriting types.
- A protected class is visible to the current package and its sub-packages.
- A private class is visible only to the current package.
- A private member is visible only to the current class andits nested classes

## Class Any provides the following methods:
- == && != : methods do not perform reference equality 
- asInstanceOf
- equals
- hashCode
- isInstanceOf
- toString

So, why not use the equals method ? Because ‘==‘ and ‘!=‘ are null safe!

### Casting:
asInstanceOf[Long]

## AnyRef ( equivalent of Java object )
 - clone.
 - eq, ne: for reference equality
 - finalize, notify, notifyAll, wait, getClass.
 - synchronized

## Imports

import java.util.{ Calendar => JavaCal }
import java.util._



## Sealed class:
- A sealed class can’t be extended.
- Just like final.
- With one exception: it can be extended only in the same file.
- The sub classes can be extended ( unless they are seal or final ).

## Parameterized Types
``` scala
class PrefixPrint[A] (prefix : String, a : A) {
def print = { println(prefix + a) }
}
// prints >>>Hello
new PrefixPrint(">>>", "Hello").print
// prints >>>5
You can force the compiler to use a specific type b specifying it in the new declaration.
new PrefixPrint[String](">>>", “” + 5) print
```

## Bounded types

- Using the ‘<:’ for upper bound.
- Using the ‘>:’ for lower bound.

```scala
class PrefixPrint[A <: AnyRef] (prefix : String, a : A) {
  def print = { println( prefix + a ) }
}
// prints >>>Hello
new PrefixPrint(">>>", "Hello").print
// does not compile
new PrefixPrint(">>>", 5) print
```

## Higher order functions

```scala
def addOne(num : Int) = num + 1
def doSomethingWithNum(num : Int, f: Int => Int) = {   f(num) }
val x = new Foo
// prints 6
println( x.doSomethingWithNum( 5, x.addOne ) )
---------------------
// You can pass an anonymous functions (lambda) as a parameter.
// prints 25
println(x.doSomethingWithNum(5, (num)=>{num*num}) )
// Variables can also have function objects.
val square = (num : Int) => {num*num}
// prints 25
println(x.doSomethingWithNum(5, square) )
// prints 11
println(x.doSomethingWithNum(5, {6 + _}) )
```
## Collections

```scala
// collect(func) – applies a partial function to every element in the domain of the function (not discussed in this course).
val coll : Traversable[Int] = List(1,2,3,4)
// will contain 3,6,9,12
val newColl = coll map {_*3}
// will contain 1,2,3,4,1,2,3,4
val newColl2 = coll ++ coll
// will contain 1,1,2,1,2,3,1,2,3,4
val newColl3 = coll flatMap {x => Range(1,x+1)}

val coll = Traversable(1,2,3,4,5)
val currentSum = 100
// foldLeft example: sums all the elements starting with
// currentSum
val newSum = coll.foldLeft(currentSum){_+_}
// prints 115
println(newSum)
// reduceLeft example: find the maximum
val max = coll reduceLeft {(a,b) => if (a > b) a else b}
// prints 5
println(max)
```
### Transformations
benchmark { // takes **4.3** seconds
```scala
val million = 1 to 10000000
val add10 = million map {_ + 10}
val mulBy2 = add10 map {_*2}
println (mulBy2 sum)}
```
// use the **view** method of Traversable to gain a lazy view on the collection
// **A view** records the operations (e.g.: map, flatMap, filter) and invokes them together (creates a new collection) only when 
```scala
required (or by invocation of force).
benchmark { // takes **420** milli-seconds
val million = 1 to 10000000
val add10 = million.**view** map {_ + 10}
val mulBy2 = add10 map {_*2}
println (mulBy2 sum)}
```
// **Parallel collections**
benchmark { // takes **275** milli-seconds
```scala
val million = 1 to 10000000
val add10 = million.par.view map {_ + 10}
val mulBy2 = add10 map {_*2}
println (mulBy2 sum)}
```
