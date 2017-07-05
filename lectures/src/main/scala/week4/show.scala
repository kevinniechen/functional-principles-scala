package week4

/**
  * Created by kevinchen on 6/29/17.
  */
object show extends App {
  def show(e: Expr): String = e match {
    case Number(n) => n.toString
    case Sum(n1, n2) => show(n1) + " + " + show(n2)
  }

  println(show(Sum(Number(1), Number(5))))
}
