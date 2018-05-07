

object Monoids extends App {
  trait Monoid[M] {
    def append(m1: M, m2: M): M
    def zero: M
  }

  implicit def mapMonoid[K,V](implicit vmonoid: Monoid[V]): Monoid[Map[K,V]] =
    new Monoid[Map[K,V]] {
      override def append(m1: Map[K, V], m2: Map[K, V]): Map[K, V] = {
        val small = if (m1.size > m2.size) m2 else m1
        val big = if (m1.size > m2.size) m1 else m2
        val afterMerge = small.map {
          case (k, vM2) =>
            val merged = big.get(k)
              .map(vM1 => vmonoid.append(vM2, vM1))
              .getOrElse(vM2)
            (k, merged)
        }
        big ++ afterMerge
      }

      override def zero: Map[K, V] = Map.empty
    }



  implicit val intMonoid = new Monoid[Int] {
    override def append(m1: Int, m2: Int): Int = m1 + m2

    override def zero: Int = 0
  }

  implicit def optMonoid[T](implicit tmonoid: Monoid[T]) =
    new Monoid[Option[T]] {
      override def append(m1: Option[T], m2: Option[T]): Option[T] = {
        if (m1.isEmpty) m2
        else if (m2.isEmpty) m1
        else for {
          a1 <- m1
          a2 <- m2
        } yield tmonoid.append(a1,a2)
      }

      override def zero: Option[T] = Some(tmonoid.zero)
    }

  def summerizeSeq[T : Monoid](seq: Seq[T]): T = {
    val monoid = implicitly[Monoid[T]]
    seq.foldLeft(monoid.zero)(monoid.append)
  }

  println(summerizeSeq(Seq(Option(1),Option(2),None)))

  val wordCounts = Seq(
    Map("test" ->3 ,"hello" ->2),
    Map("foo" -> 100, "test" -> 2)
  )

  println(summerizeSeq(wordCounts))


}