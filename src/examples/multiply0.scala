package metaprogramming

import compiletime.ops.int.S

object multiply:
  type Add[left <: Int, right <: Int] <: Int = right match
    case 0       => left
    case S[prev] => Add[S[left], prev]
