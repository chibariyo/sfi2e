object ch03_sa {
  /*
  // 3.1 Fixed-Lengh Arrays
  val nums = new Array[Int](10)
  nums.mkString("Array(", ", ", ")")

  val a = new Array[String](10)
  a.mkString("Array(", ", ", ")")

  val s = Array("Hello", "World")
  s.mkString("Array(", ", ", ")")

  s(0) = "Goodbye"
  s.mkString("Array(", ", ", ")")

  // 3.2 Variable-Length Arrrays: Array Buffers
  import scala.collection.mutable.ArrayBuffer

  val b = ArrayBuffer[Int]()
  // or new ArrayBuffer[Int]
  b.mkString("Array(", ", ", ")")

  b += 1
  b.mkString("Array(", ", ", ")")

  b += (1, 2, 3, 5)
  b.mkString("Array(", ", ", ")")

  b ++= Array(8, 13, 21)
  b.mkString("Array(", ", ", ")")

  b.trimEnd(5)
  b.mkString("Array(", ", ", ")")

  b.insert(2, 6)
  b.mkString("Array(", ", ", ")")

  b.insert(2, 7, 8, 9)
  b.mkString("Array(", ", ", ")")

  b.remove(2)
  b.mkString("Array(", ", ", ")")

  b.remove(2, 3)
  b.mkString("Array(", ", ", ")")

  val b2 = b.toArray
  b2.mkString("Array(", ", ", ")")

  for (i <- 0 until b.length)
    println(s"$i: ${b(i)}")

  for (elem <- b)
    println(elem)
  */

  /*
  // 3.4 Transforming Arrays
  // use guards and yield
  val a = Array(2, 3, 5, 7, 11)
  val result = for (elem <- a) yield 2 * elem
  result.mkString("Array(", ", ", ")")

  val result2 = for (elem <- a if elem % 2 == 0) yield 2 * elem
  result2.mkString("Array(", ", ", ")")

  // use filter and map
  val result3 = a.filter(_ % 2 == 0).map(2 * _)
  result3.mkString("Array(", ", ", ")")

  val result4 = a filter (_ % 2 == 0) map (2 * _)
  result4.mkString("Array(", ", ", ")")

  import scala.collection.mutable.ArrayBuffer
  val a2 = ArrayBuffer(0, 1, -1, 2, -2, 3, -3, 4, -4)
  a2.mkString("Array(", ", ", ")")
  var n = a2.length
  var i = 0
  while (i < n) {
    if (a2(i) >= 0) i += 1
    else { a2.remove(i); n -= 1 }
  }
  a2.mkString("Array(", ", ", ")")

  val a3 = ArrayBuffer(0, 1, -1, 2, -2, 3, -3, 4, -4)
  val result5 = for (elem <- a3 if elem >= 0) yield elem
  result5.mkString("Array(", ", ", ")")

  val positionsToRemove = for (i <- a3.indices if a3(i) < 0) yield i
  positionsToRemove.mkString("Array(", ", ", ")")
  for (i <- positionsToRemove.reverse) a3.remove(i)
  a3.mkString("Array(", ", ", ")")

  val a4 = ArrayBuffer(0, 1, -1, 2, -2, 3, -3, 4, -4)
  val positionsToKeep = for (i <- a4.indices if a4(i) >= 0) yield i
  positionsToKeep.mkString("Array(", ", ", ")")
  for (j <- positionsToKeep.indices) a4(j) = a4(positionsToKeep(j))
  a4.mkString("Array(", ", ", ")")
  a4.trimEnd(a4.length - positionsToKeep.length)
  a4.mkString("Array(", ", ", ")")
*/

  /*
  // 3.5 Common Algorithms
  Array(1, 7, 2, 9).sum

  import scala.collection.mutable.ArrayBuffer
  ArrayBuffer("Mary", "had", "a", "little", "lamb").max

  val b = ArrayBuffer(1, 7, 2, 9)
  val bSorted = b.sorted

  val bDescending = b.sortWith(_ > _)

  // you can sort an array, but not an array buffer, in place:
  val a = Array(1, 7, 2, 9)
  scala.util.Sorting.quickSort(a)
  a.mkString("Array(", ", ", ")")

  // 3.6 Deciphering Scaladoc

  // 3.7 Multidimensional Arrays
  val matrix = Array.ofDim[Double](3, 4)
  matrix(2)(3)

  val triangle = new Array[Array[Int]](10)
  for (i <- triangle.indices) {
    triangle(i) = new Array[Int](i + 1)
  }
  */

  // 3.8 Interoperating with Java
  val a = Array("Mary", "a", "had", "lamb", "little")
  // java.util.Arrays.binarySearch(a, "beef")
  // does not work
  // need to convert Array[String] to Array[Object]
  java.util.Arrays.binarySearch(a.asInstanceOf[Array[Object]], "beef")

  // binary search in scala
  import scala.collection.Searching._
  val result = a.search("beef")
  val result2 = a.search("lamb")

  // import conversion methods in scala.collection.JavaConversions
  // then you can use Scala buffers in your code,
  // and they automatically get wrapped into Java lists when calling a Java method
  import scala.collection.JavaConversions.bufferAsJavaList
  import scala.collection.mutable.ArrayBuffer

  val command = ArrayBuffer("ls", "-al", "/home/cay")
  val pb = new ProcessBuilder(command)

  // conversely, when a Java method returns a java.util.List, you can have it automatically
  // converted into a Buffer:
  import scala.collection.JavaConversions.asScalaBuffer
  import scala.collection.mutable.Buffer

  val cmd: Buffer[String] = pb.command() // Java to Scala
  // you can't use ArrayBuffer -- the wrapped object is only guaranteed to be a Buffer
}