class MinHeap(heap: Seq[Int]) {

}

object MinHeap {
  private class Node(val value: Int, var left: Node = null, var right: Node = null)

  def makeHeap(heap: Seq[Int], parent:Node): Node ={
    heap.length match {
      case 0 => _
      case 1 => parent.left = new Node(heap.head)
      case 2 =>
        parent.left = new Node(heap.head)
        parent.right = new Node(heap(1))
      case _ =>
        parent.left = {
          val newLeft = new Node(heap.head)
          newLeft.left = makeHeap(heap.slice(1, heap.length), newLeft)
          newLeft.right = makeHeap(heap.slice(2, heap.length), newLeft)
          new Node (heap.head, makeHeap(heap))
        }
    }
    parent
  }

  def countPermutations(heap: Seq[Int]): Seq[(Int, Int)] = {

  }
}
