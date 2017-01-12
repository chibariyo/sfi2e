import java.time.LocalDate

/**
  * Created by davidtateyama on 2017/01/10.
  */
object Helpers {
  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
    def date(args: Any*): LocalDate = {
      // check args
      if (args.size != 3) throw new IllegalArgumentException("number of arguments should be 3")
      for (arg <- args) {
        if (!arg.isInstanceOf[Int]) {
          throw new IllegalArgumentException("arguments should be integers")
        }
      }

      // check parts
      if (sc.parts.size != 4) throw new IllegalArgumentException("illegal format")
      if (!sc.parts(1).equals("-") || !sc.parts(2).equals("-")) {
        throw new IllegalArgumentException("parts should be delimited by '-'")
      }

      val year = args(0).toString.toInt
      val month = args(1).toString.toInt
      val day = args(2).toString.toInt
      LocalDate.of(year, month, day)
    }
  }
}

object MyApp {
  def main(args: Array[String]) {
    print("Hello basic-project!")
    import Helpers.DateInterpolator
    val year = 2017
    val month = 1
    val day = 27
    val bd = date"$year-$month-$day"
    print(bd)
  }
}