package metaprogramming

import scala.compiletime.*

object safesubs:
  object Show:
    given Show[Int] = _.toString
    given Show[Char] = _.toString

  trait Show[-entity]:
    def show(value: entity): String

  extension (context: StringContext)
    def p(subs: Any*): String =
      context.parts.zip(subs.map(_.toString)).map(_ + _).mkString+context.parts.last
