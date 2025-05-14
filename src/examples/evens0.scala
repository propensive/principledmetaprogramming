package metaprogramming

object evens:
  opaque type Even = Int

  object Even:
    import unsafeExceptions.canThrowAny
    def apply(int: Int): Even = if int%2 == 0 then int else throw Exception("Not an even number")
