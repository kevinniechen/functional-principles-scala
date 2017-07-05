object session {
  def abs(x: Double) = if (x > 0) x else -x

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if (isAccurate(guess)) guess
      else sqrtIter(improve(guess))

    def isAccurate(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }

  sqrt(4)

  sqrt(1)
}
