#Scala Notes 

## Quotes
Spans across multiple lines and don’t support escape
sequences (using triple double-quotes).

val myFile =
"""C:\Users\Shimi\Literals.scala"""

Auxiliary Constructors:

class Person (val name : String, var age : Int) {
	def this(name: String, birthDay : Date) {
		this(name, new Date().getYear - birthDay.getYear)
	}
}


Class Any provides the following methods:
• ==
• !=
• asInstanceOf
• equals
• hashCode
• isInstanceOf
• toString

Because ‘==‘ and ‘!=‘ are null safe!

Casting:

asInstanceOf[Long]

AnyRef ( equivalent of Java object )
 - clone.
 - eq, ne.
 - finalize, notify, notifyAll, wait, getClass.
 - synchronized

// assigning the default value for the type 
var stage : Int = _ 

not specifying a value makes the field abstract. 
 
About:
- Everything is object
- No static methods

import java.util.{ Calendar => JavaCal }
import java.util._


Unit: alternative to void

Primary constructor


Any provides methods:

== like equals javax

Apply - avoid to make new 

Sealed class:





- Call by value: evaluates the function arguments before calling the function
- Call by name: evaluates the function first, and then evaluates the arguments if need be

vow - final static
val language: String = "Scala" //  val is constant 
var language: String = "Scala" // var is variable

def example = 2      // evaluated when called
val example = 2      // evaluated immediately
lazy val example = 2 // evaluated once when needed

def square(x: Double)    // call by value
def square(x: => Double) // call by name
def myFct(bindings: Int*) = { ... } // bindings is a sequence of int, containing a varying # of arguments
----------------------------------------------------------
Classes:

class Customer( val name: String, val address: String ){
  private var id = "" 
}

Object Customer{
	def main( args: Array[String]){
		val eric = new Customer("name1", "name2")
		eric.id = "00001"
	}
}





---------------------------------------------------------
def loop: Int = loop

- if CBV evaluation of an expression terminates, then CBN evaluation terminates too
- The other direction is not true


// Function definition 



def first( x: Int, y:Int ) = x

CBN					CBV

first( 1, loop)		first( 1, loop )

    1				not ended
	
	def constOne(x: Int, y: => Int) = 1
	
	
	constOne( 1+2, loop) 
	constOne( 3, loop)
Answer: 3

	constOne( loop, 1+2)
	never ends
	
	
	
	def abs(x: Int) = if( x>= 0) x else -x
	
	---------------------------------------
	
	Value definitions
	
	val y = square(x)
	
	
	Example:
	def loop: Boolean = loop

	def x = loop  // ok, we've defined another name for loop
	
	val x = loop // never ends
	
	
	def and( x: Boolean, y: => Boolean ) = if(x) y else false
	def or( x: Boolean, y: => Boolean ) = if(x) true else y
	
	
	def sqrtIter( guess: Doublem x:Double ): Double =
		if(isGoodEnough(guess, x)) guess	
		else sqrtIter( improve(guess, x), x )
	
	-----------------------
	
	Bloks and lexical scope
	
  @tailrec
  def gcd( a: Int, b: Int ): Int =
    if( b == 0 ) a else gcd( b, a%b )
  

  gcd( 14, 21)
  
  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)
	
  def factorialTail1(n: Int ): Int = {
    def loop( acc: Int, n: Int ): Int =
      if (n == 0) acc
      else loop( acc * n, n - 1)
    loop(1, n)
  }

 def newSum( f: Int => Int ): ( Int, Int ) => Int = {

    def sumF( a: Int, b: Int ): Int =
      if( a > b ) 0
      else f(a) + sumF( a + 1, b)

    sumF

  }
  def sumInts = newSum( x => x )

  sumInts( 3, 5 )  
	
