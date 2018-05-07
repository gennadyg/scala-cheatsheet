package May_3

object TypeClasses1 extends App{

  def areAllEq[T]( seq: Seq[T] ): Boolean = {
    seq.headOption.exists( first => seq.forall( _ == first))
    //val mayBeOption seq.headOption.map()
    //seq.forall( _ == seq.headOption )
  }
}
