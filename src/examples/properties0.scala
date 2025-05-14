package metaprogramming

import language.dynamics

object properties:
  object Property:
    infix type of [typeclass, result] = typeclass { type Result = result }

    given osName: ("os.name" is Property of String) = identity(_)
    given javaSpec: ("java.specification.version" is Property of Int) = _.toInt
    given pathSeparator: ("path.separator" is Property of Char) = _.head

  trait Property:
    type Self <: String & Singleton
    type Result
    def read(value: String): Result

  class PropertyValue(name: String) extends Dynamic:
    def selectDynamic(part: String): PropertyValue = PropertyValue(name+"."+part)
    def apply(): String = System.getProperty(name)
    def applyDynamic(part: String)(): String = selectDynamic(part).apply()

  val java = PropertyValue("java")
  val os = PropertyValue("os")
  val path = PropertyValue("path")
