package May_3
object JsnonWriterExample extends App {
  import SupportedWriters._
  val s = "test"
  JsonWriter.write(s)
}

trait Json
object JsonWriter {
  def write[T](t: T)(implicit jsonWriter: JsonWriter[T]): Json =
    jsonWriter.write(t)

  def write2[T : JsonWriter](t: T): Json = {
    val writer = implicitly[JsonWriter[T]]
    writer.write(t)
  }
}

trait JsonWriter[T] {
  def write(t: T): Json
}


object SupportedWriters {
  implicit val stringIsJsonWritable: JsonWriter[String] =
    new JsonWriter[String] {
      def write(t: String): Json = {
        println(s"This is my json $t")
        new Json {}
      }
    }
}

object ImplisitExersize extends App{


  // define in stack
  implicit class IntExtension( val num: Int ) extends AnyVal{

    def reverse(): Int = {

      def reverset(x: Int, acc: Int = 0): Int = {
        if (x == 0)
          acc
        else {
          if (Math.abs(Int.MaxValue / 10) < Math.abs(acc)) 0 else
            reverset(x / 10, acc * 10 + (x % 10))
        }
      }

      reverset(num)
    }
  }
  implicit class Mashvan[T]( val a: T ) extends AnyVal {

    def ===( other: T ): Boolean = other == other


  }

  println( 1234 == "ded")

  println( 1234 reverse )


}