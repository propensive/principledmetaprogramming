package metaprogramming

// import language.dynamics
// import scala.compiletime.*, ops.string.*

// object properties:
//   object Property:
//     infix type of [typeclass, result] = typeclass { type Result = result }

//     given osName: ("os.name" is Property of String) = identity(_)

//     given javaSpec: Property:
//       type Self = "java.specification.version"
//       type Result = Int
//       inline def read(value: String) = value.toInt

//     given pathSeparator: ("path.separator" is Property of Char) = _.head

//   trait Property:
//     type Self <: String
//     type Result
//     def read(value: String): Result

//   erased trait PropertyValue[name <: String] extends Dynamic:
//     inline def selectDynamic[part <: String & Singleton](erased part: part)
//     : PropertyValue[name+"."+part] =

//         erasedValue[PropertyValue[name+"."+part]]

//     inline def applyDynamic[part <: String & Singleton](erased part: part)()
//                 (using property: (name+"."+part) is Property)
//     : property.Result =
//         selectDynamic[part](part).apply()

//     inline def apply()(using property: name is Property): property.Result =
//       property.read(System.getProperty(constValue[name]))

//     def foo(): Int = 42

//   erased val java = erasedValue[PropertyValue["java"]]
//   erased val os = erasedValue[PropertyValue["os"]]
//   erased val path = erasedValue[PropertyValue["path"]]
