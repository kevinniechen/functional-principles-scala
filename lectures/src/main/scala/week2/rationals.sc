class Rational(a: Int, b: Int) {
  require(b != 0, "Denominator cannot be 0.")

  def this(a: Int) = this(a, 1)

  private def gcd(a: Int, b: Int): Int =
    if(b == 0) a
    else gcd(b, a % b)

  private val g = gcd(a, b)
  val numer = a
  val denom = b

  def <(other: Rational) = this.numer * other.denom < other.numer * this.denom

  def max(other: Rational) = if(this < other) other else this

  def +(other: Rational) =
    new Rational(
      numer * other.denom + other.numer * denom,
      denom * other.denom
    )

  def -(other: Rational) =
    new Rational(
      numer * other.denom - other.numer * denom,
      denom * other.denom
    )

  def unary_- : Rational =
    new Rational(-numer, denom)

  override def toString = numer + "/" + denom
}

val x = new Rational(1,3)
val y = new Rational(5,7)
val z = new Rational(3,2)

x - y - z

x < y

x max y

-(new Rational(4))