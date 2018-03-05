package s4j.scala.chapter02

import s4j.scala.chapter02.CubeCalculator.args

class CubeCalculator {

}
object CubeCalculator extends App {

  def cube(x: Int) = {
    x * x * x
  }

  override def main(args: Array[String]): Unit = {

    val xxx = new CubeCalculator
    println("Hello, " + args.toList)
  }


}