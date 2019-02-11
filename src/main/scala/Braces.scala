package example

class Braces {

  import scala.collection.mutable
  import scala.io.StdIn

  val left = List("[", "{", "(")
  val right = List("]", "}", ")")

  def z(line: String): Int = {
    val stack = mutable.Stack[String]()

    for (i <- 0 until line.length) {
      val elem = line.charAt(i).toString
      if (left.contains(elem)) {
        stack.push(elem)
      } else if (right.contains(elem)) {
        if (stack.isEmpty) {
          return i + 1
        }
        val top = stack.top
        if ((top == "[" && elem == "]") ||
          (top == "{" && elem == "}") ||
          (top == "(" && elem == ")")) {
          stack.pop
        } else {
          return i + 1
        }
      }
    }

    if (stack.isEmpty) {
      -1
    } else {
      line.indexOf(stack.pop) + 1
    }
  }

  def aga(): Unit = {
    val line = StdIn.readLine()
    if (line.isEmpty) {
      println(0)
      return
    }
    val result = z(line)
    if (result == -1) {
      println("Success")
    } else {
      println(result)
    }
  }

  aga()
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