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
