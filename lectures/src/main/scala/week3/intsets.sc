abstract class IntSet {
  def contains(x: Int): Boolean
  def include(x: Int): IntSet
  def union(other: IntSet): IntSet
}

object EmptySet extends IntSet {
  def contains(x: Int): Boolean = false
  def include(x: Int): IntSet = new NonEmptySet(x, EmptySet, EmptySet)
  override def toString = "."
  def union(other: IntSet): IntSet = other
}

class NonEmptySet(element: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < element) left contains x
    else if (x > element) right contains x
    else true

  def include(x: Int): IntSet =
    if (x < element) new NonEmptySet(element, left include x, right)
    else if (x > element) new NonEmptySet(element, left, right include x)
    else this

  def union(other: IntSet): IntSet =
    ((left union right) union other) include element

  override def toString = "{" + left + element + right + "}"
}

val t1 = new NonEmptySet(5, EmptySet, EmptySet)
val t2 = t1 include 4
val t3 = t2 include 7
