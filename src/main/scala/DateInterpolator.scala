import java.time.LocalDate

/**
  * Created by davidtateyama on 2017/01/10.
  */
package object Implicits {
  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
    def date(args: Any*): LocalDate = {
      val strings = sc.parts.iterator
      val expressions = args.iterator
      for (xx <- strings) {
        println(xx)
      }
      for (yy <- expressions) {
        println(yy)
      }
      LocalDate.now()
    }
  }
}
