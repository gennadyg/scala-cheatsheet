
object Bla extends App {
  def seed = Random.nextInt(123)
 
  val random: Int => Int = (x: Int) => new Random(seed).nextInt(x)
  val random2: Int => Int = (x: Int) => {
    val mySeed = 123
    new Random(mySeed).nextInt(x)
  }
 
 
 
 
 
 
 
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
}