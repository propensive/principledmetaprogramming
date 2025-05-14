package metaprogramming

import unsafeExceptions.canThrowAny

object timezone:

  case class Timezone(name: String)

  extension (context: StringContext)
    def tz(): Timezone =
      val id = context.parts.head
      if java.time.ZoneId.getAvailableZoneIds().nn.contains(id) then Timezone(id)
      else throw Exception("not a valid timezone")
