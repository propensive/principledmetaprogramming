// Principled Metaprogramming in Scala 3

package metaprogramming

import escapade.*
import fulminate.*
import gossamer.*
import hellenism.*
import larceny.*
import mandible.*
import probably.*
import rudiments.*
import turbulence.*

import temporaryDirectories.environment
import classloaders.threadContext
import stdioSources.virtualMachine.ansi

object Tests extends Suite(m"Metaprogramming tests"):
  def run(): Unit =
    suite(m"Part 1: Inlining tests"):
      suite(m"date tests"):
        import dates.*

        test(m"Valid date is accepted"):
          Date(2025, 11, 8)
        . assert()

        test(m"Negative days are forbidden"):
          demilitarize:
            Date(2002, 12, -29)
          . map(_.message)
        . assert(_ == List(t"day must not be less than 1"))


        test(m"Months over 12 are forbidden"):
          demilitarize(Date(2023, 13, 1))
          . map(_.message)
        . assert(_ == List(t"month must not be greater than 12"))


        test(m"Months less than 1 are forbidden"):
          demilitarize(Date(2019, 0, 12))
          . map(_.message)
        . assert(_ == List(t"month must not be less than 1"))

        test(m"1900 is not a leap year"):
          demilitarize(Date(1900, 2, 29))
          . map(_.message)
        . assert(_ == List(t"day must not be greater than 28"))

        test(m"2000 is a leap year"):
          Date(2000, 2, 29)
        . assert()

      suite(m"properties tests"):
        import properties.*

        test(m"We can get the OS name"):
          os.name()
        . assert(_ == "Mac OS X")

        test(m"We can get the Java version as an Int"):
          demilitarize:
            val prop: Int = java.specification.version()
        . assert(_.isEmpty)

        test(m"We can get the path separator as a Char"):
          demilitarize:
            val prop: Char = path.separator()
        . assert(_.isEmpty)

      suite(m"safesubs tests"):
        import safesubs.*

        test(m"Int and chars can be substituted"):
          val i: Int = 42
          val c: Char = 'x'
          p"Testing $i $c"
        . assert(_ == "Testing 42 x")

        test(m"String cannot be substituted"):
          val i: Int = 42
          val s: String = "x"

          demilitarize:
            p"Testing $i $s"
        . assert(_.nonEmpty)

      suite(m"evens tests"):
        import evens.*

        test(m"check that we can create an even number"):
          val x: Even = Even(10)
        . assert()

        test(m"check that an Even is not typed as an Int"):
          demilitarize:
            val x: Int = Even(10)
        . assert(_.nonEmpty)

        test(m"check that an even number is a valid Even"):
          demilitarize:
            val x: Even = 42
        . assert(_.isEmpty)

        test(m"check that an odd number is not a valid Even"):
          demilitarize:
            val x: Even = 41
        . assert(_ == List(""))

      suite(m"timezone tests"):
        import timezone.*

        test(m"Timezone is valid"):
          tz"Europe/London"
        . assert(_ == Timezone("Europe/London"))


        test(m"Invalid timezone is error"):
          demilitarize:
            tz"Europe/Milan"
        . assert(_ != Nil)

      suite(m"weave tests"):
        import weaving.*

        test(m"two woven Lists produces a List"):
          demilitarize:
            val x = List(1, 2, 3).alternate(List(4, 5, 6))
            x: List[Int]
          .map(_.message)
        . assert(_ == Nil)

      suite(m"timezone tests"):
        import multiply.*

        test(m"check that we can add two singleton types"):
          summon[Add[9, 12] =:= 21]
        . assert()

        test(m"check that addition doesn't produce the wrong answer"):
          demilitarize:
            summon[Add[9, 12] =:= 22]
        . assert(_.nonEmpty)
