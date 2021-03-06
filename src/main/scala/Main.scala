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

  def minHeap(): Unit = {
    // val _ = StdIn.readLine()
    // val minHeap = StdIn.readLine().split(" ").map(_.toInt)
    println(MinHeap(Seq(7, 6, 5, 4, 3, 2)).countPermutations())
  }

  def phoneBook(): Unit = {
    import scala.collection.mutable
    val tasks = mutable.ListBuffer[String]()
    val numberOfCommands = StdIn.readLine().toInt
    for (_ <- 0 until numberOfCommands) {
      tasks += StdIn.readLine()
    }

    PhoneBook.executeTasks(tasks).foreach(println)
  }

  def hashTable(): Unit = {
    import scala.collection.mutable
    val m = StdIn.readLine().toInt
    val numberOfCommands = StdIn.readLine().toInt
    val tasks = mutable.ListBuffer[String]()
    for (_ <- 0 until numberOfCommands) {
      tasks += StdIn.readLine()
    }

    ChainedHashTable.executeTasks(m, tasks).foreach(println)
  }

  def walkTrees(): Unit = {
    import WalkTree._

    import scala.collection.mutable

    val numberOfNodes = StdIn.readLine().toInt
    val nodes = mutable.ListBuffer[Node]()
    for (index <- 0 until numberOfNodes) {
      val node = StdIn.readLine().split(" ").map(_.toInt)
      nodes += Node(node(0), index, node(1), node(2))
    }

    println(inOrder(nodes.toList).map(_.key).mkString(" "))
    println(preOrder(nodes.toList).map(_.key).mkString(" "))
    println(postOrder(nodes.toList).map(_.key).mkString(" "))
  }

  def main(args: Array[String]): Unit = {
    // braces()
    // frameQueue()
    // maxStack()
    // maxTreeHeight()
    // minHeap()
    // phoneBook()
    // hashTable()
    walkTrees()
  }
}