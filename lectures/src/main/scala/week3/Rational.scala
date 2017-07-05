package week3

/**
  * Created by kevinchen on 6/26/17.
  */
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