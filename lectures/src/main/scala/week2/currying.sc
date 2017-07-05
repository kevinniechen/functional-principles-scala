import scala.annotation.tailrec

def product(f: Int => Int)(a: Int, b: Int): Int = {
  if(a > b) 1
  else f(a) * product(f)(a + 1, b)
}

product(x => x * x)(3, 4)

def factorial(n: Int): Int = {
  product(x => x)(1, n)
}

factorial(10)

def mapReduce(f: Int => Int, operator: (Int, Int) => Int, base: Int)(a: Int, b: Int): Int = {
  @tailrec
  def loop(a: Int, acc: Int): Int = {
    if(a > b) acc
    else loop(a + 1, operator(f(a), acc))
  }
  loop(a, base)
}

mapReduce(x=>x*x, (a,b)=>a*b, 1)(3,4)
mapReduce(x=>x, (a,b)=>a+b, 0)(1,10)