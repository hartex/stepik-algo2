import scala.collection.mutable

case class MinHeap(heap: Seq[Int]) {
  private val indexes = mutable.ArrayBuffer[(Int, Int)]()

  def canSwap(heap: Seq[Int], index: Int): Boolean = {
    canSwapWithParent(heap, index) ||
      canSwapWithRightChild(heap, index) ||
      canSwapWithLeftChild(heap, index)
  }

  def canSwapWithParent(heap: Seq[Int], index: Int): Boolean = {
    val parentIndex = (index - 1) / 2
    heap(parentIndex) > heap(index)
  }

  def canSwapWithLeftChild(heap: Seq[Int], index: Int): Boolean = {
    val leftChildIndex = index * 2 + 1
    leftChildIndex < heap.length && heap(leftChildIndex) > heap(index)
  }

  def canSwapWithRightChild(heap: Seq[Int], index: Int): Boolean = {
    val rightChildIndex = index * 2 + 2
    rightChildIndex < heap.length && heap(rightChildIndex) > heap(index)
  }

  def swap(heap: Seq[Int], index1: Int, index2: Int): Seq[Int] = {
    val (parentIndex, childIndex) = if (index1 > index2) (index2, index1) else (index1, index2)
    indexes += ((parentIndex, childIndex))
    heap
      .updated(parentIndex, heap(childIndex))
      .updated(childIndex, heap(parentIndex))
  }

  def countPermutations(): Seq[(Int, Int)] = {
    def count(h: Seq[Int], index: Int): Seq[Int] = {
      if (index < 0) return h
      var a = h
      while (canSwap(a, index)) {
        if (canSwapWithParent(a, index)) {
          a = swap(a, index, (index - 1) / 2)
        } else if (canSwapWithLeftChild(a, index)) {
          a = swap(a, index, index * 2 + 1)
        } else if (canSwapWithRightChild(a, index)) {
          a = swap(a, index, index * 2 + 2)
        }
      }
      count(a, index - 1)
    }

    count(heap, heap.length - 1)
    indexes
  }
}
