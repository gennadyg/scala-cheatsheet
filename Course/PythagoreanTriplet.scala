object PythagoreanTriplet extends App{

  def forTest( min: Int, max: Int ) =
    for {
      x <- min to max - 2
      y <- x until max
      target = square(x) + square(y)
      z = squareRoot( target )
      if z <= max && square(z) == target
    } yield ( x, y, z )

  forTest( 1, 10 )

  def sumsEqualsTo( x: Int, y: Int, z: Int, sum : Int ): Option[(Int, Int, Int)] = {

    if( x + y + z == sum )

      Some( ( x,y,z ) )

    else
      None
  }
  def pythagTriple( x: Int, y: Int, z: Int ): Option[( Int, Int, Int )] = {
    if( Math.pow( x, 2 ) + Math.pow(y, 2) == Math.pow( z, 2 ) )
      Some( ( x,y,z ) )
    else
      None
  }
  // ---------------------------------------------------------------------

  def square(x: Int) = x * x
  def squareRoot(x: Int) = Math.sqrt(x).toInt

  def sortTriplet(vector: (Int, Int, Int)) =
    vector match {
      case (x, y, z) =>
        val sorted = List(x, y, z).sorted
        (sorted(0), sorted(1), sorted(2))
    }

  def isPythagorean(vector: (Int, Int, Int)) = {
    val (x, y, z) = sortTriplet(vector)
    square(x) + square(y) == square(z)
  }

  def pythagoreanTriplets(min: Int, max: Int) =
    for {
      x <- min to max - 2
      y <- x until max
      target = square(x) + square(y)
      z = squareRoot( target )
      if z <= max && square(z) == target
    } yield ( x, y, z )

  val result = pythagoreanTriplets( 1, 10 )

  println( result )

}
