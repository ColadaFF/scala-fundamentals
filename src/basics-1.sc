
// Declaracion de valores

var str: String = "Hello world"

str = "World!"

str.apply(3)

val number: Int = 12

10 + 8
10.+(8)

val big1 = BigInt.apply(12)
val big2 = BigInt(10)


big1 + big2


// Exercises


/**
 * 1. Una cadena de texto tiene el metodo *, "crazy" * 3,
 * busquen en dónde está definido y que hace.
 *
 * 2. 10 max 3, busquen en dónde está definido y que hace.
 *
 * 3. Como obtener el primer y ultimo caracter de una cadena de texto
 *
 * 4. Que hacen los metodos: drop, take, dropRight, takeRight en una
 * cadena de texto y cuales ventajas o desventajas tienen sobre substring.
 *
 * 5. Utilizar BigInt para calcular 2^1024
 *
 *
 *
 */


// 1.

val str1: String = "crazy"
str1 * 3


// 2
//RichInt

// 3
"crazy"(0)
"crazy" takeRight 1
"crazy".last

// 4
"crazy".drop(1)
"crazy".dropRight(1)
"crazy".take(1)
"crazy".takeRight(1)

//5

BigInt(2) pow 1024


val listValues = Seq(1, 2, 3, 4, 5, 6)

listValues
  .dropWhile(value => {
    if (value < 5) {
      true
    } else {
      false
    }
  })


val range = 1 to(10, 3)

for (i <- range) {
  println(i)
}


val range1 = 1 to 10
for (i <- range1; j <- 1 to 5 if i != j) {
  println(i + ", " + j)
}


for (i <- 1 to 10) yield i % 3

import scala.util.control.Breaks

val breaks = new Breaks

import breaks.{break, breakable}

breakable {
  for (i <- 1 to 10) {
    println(i)
    if (i > 6) {
      break()
    }
  }
}


def abs(number: Int): Int = {
  if (number > 0) number else -number
}


def multiplyBy(value: Int, multiplier: Int = 1): Int = {
  value * multiplier
}

def decorate(left: String = "[", value: String, right: String = "]"): String = {
  left + value + right
}

def printData(value: String, decorateFn: String => String): Unit = {
  print(decorateFn(value))
}


multiplyBy(1)
decorate(value = "Hi there", right = "}", left = "{")

val stringToString: String => String = value => "{" + value + "}"
printData("Hello", stringToString)


def sumAll(args: Int*) = {
  var result = 0
  for (arg <- args) {
    result += arg
  }
  result
}

def sumList(values: List[Int]) = sumAll(values: _*)


val resultValues1 = sumAll(1, 2, 3, 4, 5)



val rangeToSum = 1 to 5
// :_* => transformar la coleccion de datos en una coleccion de argumentos
sumAll(rangeToSum: _*)


def recursiveSum(args: Int*): Int = {
  if (args.isEmpty) 0
  else args.head + recursiveSum(args.tail: _*)
}


recursiveSum(1 to 5: _*)


lazy val lazyValue: Int = {
  println("Evaluated")
  4
}


val noLazyValue = {
  // ... expensive computation
  4
}


lazy val words: String = scala.io.Source.fromFile("/Users/barcode/Desktop/data.txt")
  .mkString


print(words)

// curry


/**
 * Ejercicios
 *
 * 1. El signo de un numero es 1 cuando es positivo, -1 cuando es negativo
 * 0 cuando es 0. Escribir una funcion que determine el signo de un numero
 *
 * 2. Cual es el valor de un bloque de expresion vacía {}? cual es el tipo?
 *
 * 3. Escribir el equivalente en Scala de este código java:
 *
 * for(int i = 10; i >= 0; i--) System.out.println(i);
 *
 * 4. Escribir una función que imprima los valores desde n hasta 0
 * ex: countdown(n: Int): Unit
 *
 * 5. Escribir un ciclo for para obtener el producto del valor unicode
 * de todas las letras en una cadena de texto. Por ejempo, el producto
 * de los caracteres en "Hello" es 9415087488L
 *
 * 6. Resolver el ejercicio anterior sin un ciclo.
 * Tip: Ver la documentación de la clase StringOps
 *
 * 7. Escribir el ejercicio anterior con una función recursiva.
 *
 */




