import java.util.{Date, UUID}

import scala.runtime.Nothing$
import scala.util.Try

case class Person(firstName: String, lastName: String)

object Validator {
  def inspect(person: Person): String =
    person match {
      case Person("luke", "padman") => "Stop"
      case Person("rian", "Stone") => "Stop"
      case Person("luke", _) => "Wait, a Luke?"
      case Person(_, "Stone") => "Wait, a Stone?"
      case Person(first, _) => s"Move on! $first"
      case _ => "Move on !"
    }
}

// constants
def describe(x: Any): String = x match {
  case 5 => "five"
  case true => "Truth"
  case _ => "something else"
}

val deepResult = describe(true) match {
  case _ => ""
}



// variable
def validate(x: Any) = x match {
  case 0 => "zero"
  case somethingElse => s"not zero: $somethingElse"
}

// constructor
def describeConstructor(x: Person) = x match {
  case Person("luke", "walker") => println("Deep match")
}

// sequence
def describeSequence(x: Seq[Any]) = x match {
  case Seq(0, _*) => "Found it"
}


// types
def describeTypes(x: Any) = x match {
  case s: String => s.length
  case m: Int => m
  case list: List[_] => list.length
}


// Variable binding
def describeConstructor(x: Person) = x match {
  case Person("luke", "walker") => println("Deep match")
  case p@Person("rian", "stone") => p
}


/**
 * Syntax
 *
 * expr0 match {
 * case pattern1 => expr1
 * case pattern2 => expr2
 * case _ => defaultExpr
 * }
 *
 * Donde:
 *    - La expresión "expr0" evalua el valor que queremos coincidir
 *    - Los patrones o "guards" pattern1, pattern2 entre otros son
 * checkeados frente al valor
 *    - Las expresiones del lado derecho expr1, expr2 son los resultados
 * en caso de que el patron pase la validación
 *
 */


/**
 * Exercises!
 *
 * 1. Definir un objeto "ChipShop" con el metodo "willServe". Este
 * metodo acepta un "Cat" (clase Cat) y retorna verdadero si la comida
 * favorita del gato es "chips" o falso si es cualquier otra.
 * Usar pattern matching
 *
 * 2. con la clase Film
 *
 * case class Film(name: String, year: Int, director: Person)
 *
 * definir un objeto Evaluator con un metodo rate que recibe un valor
 * Film y retorna:
 *
 * si el director es Rian Stone retorna 10.0
 * si el director es Carl Bach retorna 7.0
 * para cualquier otro retorna 3.0
 *
 */

case class Cat(color: String, food: String)

object ChipShop {
  def willServe(cat: Cat) = cat match {
    case Cat(_, "chips") => true
    case _ => false
  }
}

case class Film(name: String, year: Int, director: Person)

object Evaluator {
  def rate(film: Film): Double = film match {
    case Film(_, _, Person("rian", "stone")) => 10.0
    case Film(_, _, Person("carl", "bach")) => 7.0
    case _ => 3.0
  }
}

sealed trait JsValue

case class JsString(value: String) extends JsValue

case class JsNumber(value: Number) extends JsValue

case object JsNull extends JsValue

trait JsBoolean extends JsValue

case object JsTrue extends JsBoolean

case object JsFalse extends JsBoolean


def isFalse(x: JsValue) = x match {
  case JsString(value) =>
  case JsNumber(value) =>
  case JsNull =>
  case boolean: JsBoolean =>
  case JsString(value) =>
  case JsNumber(value) =>
  case JsNull =>
  case boolean: JsBoolean =>
}


// Traits

// Web visitor

case class AnonymousWithoutTrait(id: String, createdAt: Date = new Date())

case class UserWithoutTrait(id: String, email: String, createdAt: Date = new Date())

sealed trait Visitor {
  def id: String

  def createdAt: Date


  def age: Long = new Date().getTime - createdAt.getTime
}

/*object Visitor {
  def randomAnonymous(): Anonymous = Anonymous(UUID.randomUUID().toString)
}*/

case class Anonymous(
                      id: String,
                      createdAt: Date = new Date()
                    ) extends Visitor


case class User(
                 id: String,
                 email: String,
                 createdAt: Date = new Date()
               ) extends Visitor {

  override def age: Long = super.age
}

def check(visitor: Visitor) = visitor match {
  case Anonymous(id, createdAt) =>
  case User(id, email, createdAt) =>
}


/**
 * Exercises
 *
 * 1. Gatos y más gatos!
 *
 * Construir un trait "Feline" con los subtipos Tiger, Lion, Panther
 * y Cat, con las siguientes reglas:
 *    - En "Feline" una propiedad color: String
 *    - En "Feline" una propiedad sound:String que es "meow" para Cat
 * y "roar" para el resto
 *    - solo Cat tiene una comida favorita (food: String)
 *    - Lion tiene una propiedad size:Int
 *
 * 2. Definir un trait "Shape" que debe tener 3 metodos abstractos
 *  - sides que retorna el número de lados
 *  - perimeter que retorna el total del tamaño de los lados
 *  - area que retorna el area
 *
 * Implementar Shape en tres clases: Circle, Rectangle y Square, en
 * cada caso proveer las implementaciones de los metodos
 */


trait Feline {
  def sound: String

  def color: String
}

case class Cat(color: String, food: String) extends Feline {
  val sound: String = "meow"
}

trait BigCat extends Feline {
  def sound = "roar"
}

case class Tiger(color: String) extends BigCat

case class Panther(color: String) extends BigCat

case class Lion(color: String, size: Int) extends BigCat


trait Shape {
  def sides: Int

  def perimeter: Double

  def area: Double
}

case class Circle(radius: Double) extends Shape {
  val sides = 1

  override def perimeter: Double = ???

  override def area: Double = ???
}


trait Rectangular extends Shape {
  def width: Double

  def height: Double

  def sides = 4

  def perimeter: Double = 2 * height + 2 * width

  def area: Double = height * width
}

case class Square(sideSize: Double) extends Rectangular {
  override def height: Double = sideSize

  override def width: Double = sideSize
}

case class Rectangle(height: Double, width: Double) extends Rectangular


sealed trait DivisionResult

final case class Finite(value: Double) extends DivisionResult

case object Infinite extends DivisionResult

object DivisionResult {
  def apply(num: Int, den: Int): DivisionResult =
    if (den == 0) Infinite else Finite(num / den)
}

DivisionResult(1, 0) match {
  case Finite(value) =>
  case Infinite =>
}


/**
 * Ex
 *
 * 1. Crear el trait de TryInt con SuccessInt o FailureInt
 */
/*

sealed trait Try[IN] {
  def value: Option[IN]

  def exception: Option[Exception]

  def isSuccess: Boolean

  def isFailure: Boolean

  def map[OUT](mapper: IN => OUT): Try[OUT]
}


case class Success[T](valueBase: T) extends Try[T] {
  val value: Option[T] = Some(valueBase)
  val exception: Option[Exception] = None

  override def isSuccess = true

  override def isFailure = false

  override def map[OUT](mapper: T => OUT): Try[OUT] =  Try(() => mapper(value.get))
}

case class Failure[T](exceptionBase: Exception) extends Try[T] {
  val value: Option[T] = None
  val exception: Option[Exception] = Some(exceptionBase)


  override def isSuccess = false

  override def isFailure = true

  override def map[OUT](mapper: T => OUT) = Failure(exceptionBase)
}

case object Try {
  def apply[T](supplier: () => T): Try[T] = {
    try {
      Success(supplier())
    } catch {
      case e: Exception => Failure(e)
    }
  }
}

Try(() => 1)
Try(() => {
  throw new ArithmeticException()
})*/



