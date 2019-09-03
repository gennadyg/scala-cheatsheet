// A Case Class is just like a regular class, which has a feature for modeling unchangeable data. 
// It is also constructive in pattern matching. It has been defined with a modifier case, due to this case keyword, 
// we can get some benefits to stop oneself from doing a sections of codes that have to be included in many places 
// with little or no alteration. As we can see below a minimal case class needs the keyword case class, an identifier, 
// and a parameter list which may be vacant.

Case class className(parameters)

Note: The Case class has a default apply() method which manages the construction of object.

It is serializable.
It has a by default hashCode implementation.

// Scala program of case class and case Object 
case class employee (name:String, age:Int) 
object Main 
{ 
	// Main method 
	def main(args: Array[String]) 
	{ 
		var c = employee("Nidhi", 23) 
		
		// Display both Parameter 
		println("Name of the employee is " + c.name); 
		println("Age of the employee is " + c.age); 
	} 
} 

//  affix a method with the name of the class having identical number of parameters
var Book1 = Book("Data Structure and Algorithm", "cormen") 

 // Scala compiler affixes val or var for all the parameters of constructor so, we won’t be able to 
 // reassign a new value to them once that class object is constructed that’s why even in absence of val or var, 
 // case class’s constructor parameters will turn out to be class members, 
// that is not practicable for regular classes.

// The Scala compiler also appends a copy() method to case class that is utilized to create a duplicate of 
// the same object with changing some parameters or without altering them.

val s1 = Student("Nidhi", 23) 
          
        // Display parameter 
        println("Name is " + s1.name); 
        println("Age is " + s1.age); 
        val s2 = s1.copy() 
        OR
        val s2 = s1.copy(age = 24) 
