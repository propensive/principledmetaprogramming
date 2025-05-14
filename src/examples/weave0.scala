package metaprogramming

object weave:
  extension [element](left: Iterable[element])
    def weave(right: Iterable[element]): Iterable[element] =
      left.zip(right).flatMap(Iterable(_, _))
