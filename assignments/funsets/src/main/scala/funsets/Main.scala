package funsets

object Main extends App {
  import FunSets._

  println("Singleton")
  assert(contains(singletonSet(1), 1))
  assert(!contains(singletonSet(1), 0))

  println("Union")
  val unionSet1 = union(singletonSet(1),singletonSet(2))
  assert(contains(unionSet1,1))
  assert(contains(unionSet1,2))
  assert(!contains(unionSet1,0))

  println("Intersect")
  val unionSet2 = union(singletonSet(2),singletonSet(3))
  val unionSet3 = intersect(unionSet1, unionSet2)
  assert(contains(unionSet3,2))
  assert(!contains(unionSet3,1))
  assert(!contains(unionSet3,3))
  assert(!contains(unionSet3,0))

  println("Diff")
  val unionSet4 = diff(unionSet1, unionSet2)
  assert(contains(unionSet4, 1))
  assert(!contains(unionSet4, 2))
  assert(!contains(unionSet4, 3))

}
