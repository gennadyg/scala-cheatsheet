class Adder {
  def apply(a: Int, b: Int) = a + b
}

object Adder {
  val add = new Adder()
  add.apply(1, 3)
  add(1, 3)
}
