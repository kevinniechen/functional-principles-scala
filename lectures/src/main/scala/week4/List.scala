package week4

/**
  * Created by kevinchen on 6/26/17.
  */
trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

//object List {
//  def apply[T]: List[T] = new Nil
//  def apply[T](n: T): List[T] = new Cons(n, new Nil)
//  def apply[T](n: T, n2: T): List[T] = new Cons(n, List[T](n))
//}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false
}

object Nil extends List[Nothing] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("nil head")
  def tail: Nothing = throw new NoSuchElementException("nil tail")
}
