package metaprogramming

import language.dynamics
import scala.compiletime.*, ops.string.*

// object properties:
//   object Property:
//     infix type of [typeclass, result] = typeclass { type Result = result }

//     given osName: ("os.name" is Property of String) = identity(_)
//     given javaSpec: ("java.specification.version" is Property of Int) = _.toInt
//     given pathSeparator: ("path.separator" is Property of Char) = _.head

//   trait Property:
//     type Self <: String
//     type Result
//     def read(value: String): Result

//   class PropertyValue[name <: String]() extends Dynamic:
//     def selectDynamic[part <: String & Singleton](part: part): PropertyValue[name+"."+part] =
//       PropertyValue[name+"."+part]()

//     inline def applyDynamic[part <: String & Singleton](part: part)()
//                 (using property: (name+"."+part) is Property)
//     : property.Result =

//         selectDynamic[part](part).apply()

//     inline def apply()(using property: name is Property): property.Result =
//       property.read(System.getProperty(constValue[name]))

//   val java = PropertyValue["java"]()
//   val os = PropertyValue["os"]()
//   val path = PropertyValue["path"]()
