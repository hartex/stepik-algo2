object Braces {

  import scala.collection.mutable

  val left = List("[", "{", "(")
  val right = List("]", "}", ")")

  def findError(line: String): Int = {
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
}