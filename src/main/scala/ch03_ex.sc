object ch03_ex {
  // 1.
  val n = 10
  import scala.util.Random
  def createRandomArray(n: Int) = {
    val a = new Array[Int](n)
    for (i <- 0 until n) {
      a(i) = Random.nextInt
    }
    a
  }
  val a = createRandomArray(n)
  a.mkString("Array(", ", ", ")")

  // 2.
  def swapAdjacent(a: Array[Int]) = {
    for (i <- a.indices by 2) {
      if (i+1 < a.length) {
        val tmp = a(i)
        a(i) = a(i+1)
        a(i+1) = tmp
      }
    }
  }
  val a2 = Array(1, 2, 3, 4, 5)
  swapAdjacent(a2)
  a2.mkString("Array(", ", ", ")")

  // 3.
  def swapAdjacentUsingForYield(a: Array[Int]) = {
    for (i <- a.indices) yield {
      if (i % 2 == 0) {
        if (i+1 < a.length) {
          a(i+1)
        } else {
          a(i)
        }
      } else {
        a(i-1)
      }
    }
  }
  val a3 = Array(1, 2, 3, 4, 5)
  val a4 = swapAdjacentUsingForYield(a3)
  a4.mkString("Array(", ", ", ")")
}