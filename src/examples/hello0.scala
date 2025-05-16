package metaprogramming

import scala.quoted.*

object hello:
  inline def hello(name: String): Unit =
    ${ helloImplementation('{name}) }

  def helloImplementation(name: Expr[String])(using Quotes): Expr[Unit] =
    val name2: Expr[String] = Expr(name.valueOrAbort)
    '{ println(s"Hello "+${name2}) }
