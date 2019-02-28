object Main {

  import scala.io.StdIn

  def braces(): Unit = {
    val line = StdIn.readLine()
    if (line.isEmpty) {
      println(0)
      return
    }
    val result = Braces.findError(line)
    if (result == -1) {
      println("Success")
    } else {
      println(result)
    }
  }

  def frameQueue(): Unit = {
    val _ = StdIn.readInt
    val array = StdIn.readLine.split(" ").map(_.toInt)
    val frameLength = StdIn.readInt
    println(FrameQueue.findMaxes(array, frameLength))
  }

  def maxStack(): Unit = {
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

  def maxTreeHeight(): Unit = {
    val _ = StdIn.readLine()
    val tree = StdIn.readLine().split(" ").map(_.toInt)
    println(MaxTreeHeight.find(tree))
  }

  def minHeap ():Unit = {
    // val _ = StdIn.readLine()
    // val minHeap = StdIn.readLine().split(" ").map(_.toInt)
    println(MinHeap(Seq(7, 6, 5, 4, 3, 2)).countPermutations())
  }
  def main(args: Array[String]): Unit = {
    // braces()
    // frameQueue()
    // maxStack()
    // maxTreeHeight()
    minHeap()
  }
}