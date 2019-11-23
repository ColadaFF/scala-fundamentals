

object ScalaRunner extends App {
  var result = ""
  val reverseArgs = args.reverse
  for (arg <- reverseArgs) {
    result += arg + ", "
  }


  args.foldRight("") {(acc, actual) => {
    acc + "," + actual
  }}

  println(result)

  println(result)
}