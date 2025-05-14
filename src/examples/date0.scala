package metaprogramming

object dates:
  object Date:
    def error(message: String): Nothing = throw new Error(message)

    def apply(year: Int, month: Int, day: Int): Date =
      if day < 1 then error("day must not be less than 1")
      if month < 1 then error("month must not be less than 1")
      month match
        case 1 | 3 | 5 | 7 | 8 | 10 | 12 =>
          if day > 31 then error("day must not be greater than 31")

        case 4 | 6 | 9 | 11 =>
          if day > 30 then error("day must not be greater than 30")

        case 2 =>
          val leapYear = year%400 == 0 || year%4 == 0 && year%100 != 0
          if leapYear then
            if day > 29 then error("day must not be greater than 29")
          else
            if day > 28 then error("day must not be greater than 28")

        case _ =>
          error("month must not be greater than 12")

      new Date(year, month, day)

  class Date(year: Int, month: Int, day: Int)
