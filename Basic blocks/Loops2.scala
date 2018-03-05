
package s4j.scala.chapter13

object Do extends App {

/* List<String> reversedNames = new ArrayList<String>();
for (String n : nameList) {
  reversedNames.add(n.reverse());
}
return reversedNames;
*/

	for (n <- nameList) yield n.reverse
	// which is sugar for:
	nameList.map(_.reverse)

}

object DoWithFor extends App {

/*
for (String n : nameList) {
  System.out.println("Hi, " + n);
}
*/
 for (n <- nameList) {
  println("Hi, " + n)
}
 
// which is sugar for:
 
nameList.foreach(n => println("Hi, " + n)
}

