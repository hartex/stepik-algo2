import scala.collection.mutable

case class MinHeap(heap: Seq[Int]) {
  private val indexes = mutable.ArrayBuffer[(Int, Int)]()

  def canSwap(heap: Seq[Int], index: Int): Boolean = {
    val parentIndex = (index - 1) / 2
    heap(parentIndex) > heap(index)
  }

  def swap(heap: Seq[Int], index: Int): Seq[Int] = {
    val parentIndex = (index - 1) / 2
    indexes += ((parentIndex, index))
    heap
      .updated(parentIndex, heap(index))
      .updated(index, heap(parentIndex))
  }

  def countPermutations(): Seq[(Int, Int)] = {
    def count(h: Seq[Int], index: Int): Seq[Int] = {
      if (index < 0) return h
      var a = h
      while (canSwap(a, index)) {
        a = swap(a, index)
      }
      count(a, index - 1)
    }

    count(heap, heap.length - 1)
    indexes
  }
}
