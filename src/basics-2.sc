/**
 * Classes
 * Objects
 * Traits
 */


/*class Person {
  private val personType: String = "Normal"

  def getPersonType = personType
}*/


class Hour(val value: Int) {
  def this() {
    this(10)
  }
}


var hour = new Hour(12)

hour.value

hour = new Hour(123)


/**
 * 1. Constuir clase Counter con attributo value que inicia en 0,
 * y tiene un metodo para incrementar y otro para decrementar
 *
 *
 * 2. Construir una versión inmutable del ejercicio anterior.
 */


class Counter(var value: Int = 0) {
  def increment(): Unit = value += 1

  def decrement(): Unit = value -= 1
}


class ImmutableCounter(val value: Int = 0) {
  def increment(): ImmutableCounter = new ImmutableCounter(value + 1)

  def decrement(): ImmutableCounter = new ImmutableCounter(value - 1)
}

val counter = new Counter


/**
 * class Name([var|val] parameter: type, ...) {
 * declarationOrExpressions
 * }
 *
 * Exercises
 *
 * 1. Escribir de nuevo Counter dónde los metodos de motificación permitan ingresar
 * una cantidad como argumento
 *
 * 2. Con esta clase Adder
 * class Adder(amount: Int) {
 * def add(in: Int) = in + amount
 * }
 *
 * Extender la clase counter para agregar un metodo "adjust". Este metodo debe aceptar
 * un "Adder" y retornar un nuevo "Counter" con el resultado de aplicar el Adder.add
 * al "value" de counter
 *
 */

class ImmutableCounter1(val value: Int = 0) {
  def increment(amount: Int = 1): ImmutableCounter = new ImmutableCounter(value + amount)

  def decrement(amount: Int = 1): ImmutableCounter = new ImmutableCounter(value - amount)
}


class Adder(amount: Int) {
  def add(in: Int): Int = in + amount
}

class ImmutableCounterWithAdder(val value: Int = 0) {
  def increment(amount: Int = 1): ImmutableCounter = new ImmutableCounter(value + amount)

  def decrement(amount: Int = 1): ImmutableCounter = new ImmutableCounter(value - amount)

  def adjust(adder: Adder): ImmutableCounterWithAdder = {
    new ImmutableCounterWithAdder(adder.add(value))
  }
}

val adder = new Adder(3)

val counterImmutable = new ImmutableCounterWithAdder(10)

val counterWithAdder = counterImmutable.adjust(counterWithAdder)

/**
 * Objects
 */


object Utilities {
  var currentCounter = 0

  def getNewId() = {
    currentCounter += 1
    currentCounter
  }
}


class AdderWithObject(amount: Int) {
  def add(in: Int): Int = in + amount
}

object AdderWithObject {
  def ofOne(): AdderWithObject = new AdderWithObject(1)
}


val adderWithObject = AdderWithObject.ofOne()


class Timestamp(val seconds: Long)

object Timestamp {
  def apply(hours: Int, minutes: Int, seconds: Int): Timestamp = {
    new Timestamp(hours * minutes * seconds)
  }
}


Timestamp(12, 41, 12).seconds


/**
 * Exercises
 *
 * 1. Implementar la clase persona con un objeto de compañia, la clase debe recibir
 * 2 parametros en el constructor: nombre y apellido y el objeto de compañía debe ser capaz
 * de crear la instacia de persona solo con la cadena de texto completa en vez de sus partes
 * individuales
 *
 * Tip: usar String.split(" ") para separar las partes
 *
 **/


class Person(val name: String, val lastName: String)

object Person {
  def apply(fullName: String): Person = {
    val parts = fullName.split(" ")
    new Person(parts(0), parts(1))
  }
}

// No recomendable
object RunnerWithMain {
  def main(args: Array[String]): Unit = {
    println(args)
  }
}

// Este si
object Runner extends App {
  println(args)
}


// ENUMS

object Colors extends Enumeration {
  val RED = Value
  val BLACK = Value
  val WHITE = Value
}

Colors.BLACK


// case Classes
// case Objects


case class PersonCase(firstName: String, lastName: String)


val personCase = PersonCase("Andres", "Perez")
val personCase2 = PersonCase("Andres", "Perez")

personCase.equals(personCase2)


personCase.copy(lastName = "Montoya", firstName = "Camilo")


case object InvalidPolicy {
  val value = 0
  val expiration = -1
}


/**
 * Exercises
 *
 *
 * 1. Escribir un objeto Conversions con los metodos inchesToCentimeters,
 * gallonsToLiters y milesToKilometers
 *
 * 2. Escribir el ejercicio anterior con una superclase UnitConversions y
 * definir 3 objetos que extiendan de esta
 *
 * 3. Definir una clase Point con los atributos (x:Int, y:Int) que pueda
 * ser construida usando la sintaxis => val point = Point(3, 2)
 *
 * 4. Escribir una aplicación en Scala, usando el trait App, que imprima
 * por consola sus argumentos de manera inversa separados por un espacio.
 *
 * 5. Escribir un  enum de los colores primarios en el cual el nombre
 * de los valores esté en mayúscula y el valor retornado por el método
 * toString() retorne en minúscula.
 *
 * Implementar usando case classes y case objects
 *
 *  6. Escibir una clase Cat que reciba el color y la comida del gato.
 *
 *  7. Implementar la anterior clase Counter con los metodos increment
 * y decrement usando case classes
 *
 *  8. Implementar el código para representar los siguientes objetos
 *
 * Una cuenta de ahorros que tiene un balance y metodos para depositar
 * y para debitar
 * Una cuenta corriente que tiene un balance metodos para depositar
 * y para debitar
 * Una cuenta vacia, cuyo balance es siempre 0 y los metodos para
 * depositar y para debitar lanzan una excepción.
 *
 * Tip: lanzar una excepción de Java.
 *
 * Repositorio: https://github.com/ColadaFF/scala-fundamentals
 *
 */

object Conversions {
  def inchesToCentimeters(value: Double): Double = ???

  def gallonsToLiters(value: Double): Double = ???

  def milesToKilometers(value: Double): Double = ???
}

abstract class UnitConversions {
  def apply(value: Double): Double

  def apply(value: Float): Float
}

object InchesToCentimeters extends UnitConversions {
  override def apply(value: Double) = ???

  override def apply(value: Float) = ???
}

object GallonsToLiters extends UnitConversions {
  override def apply(value: Double) = ???

  override def apply(value: Float) = ???
}

object MilesToKilometers extends UnitConversions {
  override def apply(value: Double) = ???

  override def apply(value: Float) = ???
}


InchesToCentimeters(3.14)
GallonsToLiters(3.14)
MilesToKilometers(3.14)


class Point(var x: Int, val y: Int)

object Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)
}

Point(2, 3)

// 5


object Colors extends Enumeration {
  val YELLOW = Value("yellow")
  val RED = Value("red")
  val BLUE = Value("blue")
}


case class Cat(color: String, food: String)


case class Counter(initialValue: Int = 0, adder: Adder) {
  def inc: Counter = this.copy(initialValue = initialValue + 1)

  def dec: Counter = ???
}

type Amount = BigDecimal
type Balance = BigDecimal

abstract class Account(balance: Balance) {
  final def debit(amount: Amount) = ???
  def credit(amount: Amount) = ???
}

case class SavingsAccount(balance: Balance) extends Account(balance)

case object EmptyAccount extends Account(0)  {

}


trait JsValue

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
  case boolean: JsBoolean if boolean.asInstanceOf[JsFalse] =>
  case _ =>
}

// Trait
// Pattern matching


