import scala.collection.mutable

class MinHeap(heap: Seq[Int]) {
  private val indexes = mutable.ArrayBuffer[(Int, Int)]()

  def liftUp(heap: Seq[Int], index: Int): Seq[Int] = {
    if (index - 1 < 0) return heap

    val parentIndex = (index - 1) / 2
    liftUp(
      if (heap(parentIndex) > heap(index)) {
        indexes += ((parentIndex, index))
        heap
          .updated(parentIndex, heap(index))
          .updated(index, heap(parentIndex))
      } else {
        heap
      }, index - 1)
  }

  def countPermutations(heap: Seq[Int]): Seq[(Int, Int)] = {
    for (index <- (heap.length - 1) until 0 by 1) {
      liftUp(heap, index)
    }
    indexes
  }
}
