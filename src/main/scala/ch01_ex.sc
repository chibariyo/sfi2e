object ch01_ex {
  // 1.
  3.abs
  3.doubleValue

  // 2.
  import scala.math._
  val a = sqrt(3)
  val b = a * a
  val c = 3 - b

  // 3.
  // val

  // 4.
  val d = "crazy" * 3

  // 5.
  val e = 10 max 2

  // 6.
  val f = BigInt(2).pow(1024)

  // 7.
  import scala.math.BigInt.probablePrime
  import scala.util.Random
  val g = probablePrime(100, Random)

  // 8.
  val h = g.toString(36)

  // 9.
  val i = "hello world"
  val j = i(0)
  val k = i.last

  // 10.
  val l = i.take(3)
  val m = i.drop(3)
  val n = i.takeRight(3)
  val o = i.dropRight(3)
}