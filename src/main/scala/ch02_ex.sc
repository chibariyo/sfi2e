object ch02_ex {
  // 1.
  def signum(n: Int) = if (n > 0) 1 else if (n < 0) -1 else 0

  signum(10)
  signum(-10)
  signum(0)

  // 2. value = (), type = Unit
  val a = ()

  // 3.
  var x: Unit = null
  var y: Int = 0
  x = y = 1

  // 4.
  for(i <- 10 to 0 by -1) println(i)

  // 5.
  def countdown(n: Int): Unit = {
    for (i <- n to 0 by -1) println(i)
  }

  countdown(10)

  // 6.
  val str = "Hello"
  var prod: Long = 1
  for (ch <- str) prod = ch.toInt * prod

  // 7.
  str.foldLeft(1L)(_ * _.toInt)

  // 8.
  def product(str: String): Long = {
    str.foldLeft(1L)(_ * _.toInt)
  }

  product(str)

  // 9.
  def productRecursive(str: String): Long = {
    if (str.length == 0) 1 else str(0).toInt * productRecursive(str.drop(1))
  }

  productRecursive(str)

  // 10.
  def xtonth(x: Int, n: Int): Double = {
    if (n > 0) {
      if (n % 2 == 0) {
        xtonth(x, n/2)*xtonth(x, n/2)
      } else {
        x * xtonth(x, n - 1)
      }
    } else if (n < 0) {
      1 / xtonth(x, -n)
    } else {
      1
    }
  }
  xtonth(2, 2)
  xtonth(2, -2)
  xtonth(2, 0)
  xtonth(2, 4)
  xtonth(2, 10)

  import Implicits.DateInterpolator
  val year = 2017
  val month = 1
  val day = 27
  val bd = date"$year-$month-$day"
}