package example

class MaxStack {

  import scala.collection.mutable

  val stack = mutable.Stack[Int]()
  private val inner = mutable.Stack[Int]()

  def pop(): Int = {
    inner.pop()
    stack.pop()
  }

  def push(value: Int) = {
    if (inner.isEmpty) {
      inner.push(value)
    } else {
      val innerTop = inner.top
      inner.push(value max innerTop)
    }
    stack.push(value)
  }

  def max: Int = {
    if (inner.isEmpty) {
      0
    } else {
      inner.top
    }
  }
}

object Main {

  import scala.io.StdIn

  def main(args: Array[String]): Unit = {
    val stack = new MaxStack()

    for (_ <- 0 until StdIn.readInt) {
      val line = StdIn.readLine
      line match {
        case "pop" => stack.pop()
        case "max" => println(stack.max)
        case s if s.startsWith("push") => stack.push(s.stripPrefix("push ").toInt)
      }
    }
  }
}
