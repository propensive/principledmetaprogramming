package metaprogramming

object alternate:
  extension [element](left: Iterable[element])
    def alternate(right: Iterable[element]): Iterable[element] =
      left.zip(right).flatMap(Iterable(_, _))
