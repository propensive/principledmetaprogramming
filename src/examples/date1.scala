package metaprogramming

// object dates:
//   object Date:
//     inline def apply(year: Int, month: Int, day: Int): Date =
//       if day < 1 then compiletime.error("day must not be less than 1")
//       if month < 1 then compiletime.error("month must not be less than 1")
//       inline month match
//         case 1 | 3 | 5 | 7 | 8 | 10 | 12 =>
//           if day > 31 then compiletime.error("day must not be greater than 31")

//         case 4 | 6 | 9 | 11 =>
//           if day > 30 then compiletime.error("day must not be greater than 30")

//         case 2 =>
//           inline val leapYear = year%400 == 0 || year%4 == 0 && year%100 != 0
//           inline if leapYear then
//             inline if day > 29 then compiletime.error("day must not be greater than 29")
//           else
//             inline if day > 28 then compiletime.error("day must not be greater than 28")

//         case _ =>
//           compiletime.error("month must not be greater than 12")

//       new Date(year, month, day)

//   class Date(year: Int, month: Int, day: Int)
