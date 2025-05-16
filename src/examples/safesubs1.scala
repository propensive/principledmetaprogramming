package metaprogramming

import scala.compiletime.*

// object safesubs:
//   object Show:
//     given Show[Int] = _.toString
//     given Show[Char] = _.toString

//   trait Show[-entity]:
//     def show(value: entity): String

//   extension (inline context: StringContext)
//     transparent inline def p[subs](inline subs: subs): String =
//      inline subs match
//        case tuple: Tuple =>
//          val shows = summonAll[Tuple.Map[tuple.type, Show]]

//          val mapped = tuple.zip(shows).map[[q] =>> String]:
//            [elemType] => elem =>
//              elem match
//                case (value, show: Show[t]) => show.show(value.asInstanceOf[t])
//                case _                         => ""

//          context.parts.zip(mapped.toList).map(_ + _).mkString+context.parts.last

//        case value =>
//          context.parts.head+summonInline[Show[value.type]].show(value)+context.parts.last
