package metaprogramming

import compiletime.ops.int.S
import compiletime.*

object multiply2:
  type Concat[left <: Tuple, right <: Tuple] <: Tuple = right match
    case EmptyTuple   => left
    case head *: tail => Concat[head *: left, tail]


  erased val x: (Double, Exception, Int, String) =
    erasedValue[Concat[(Int, String), (Exception, Double)]]

  def concat[left <: Tuple, right <: Tuple](left: left, right: right): Concat[left, right] =
    right match
      case empty: EmptyTuple     => left
      case right: (head *: tail) => right match
        case head *: tail =>
          concat(head *: left, tail)
