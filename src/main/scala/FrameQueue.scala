import scala.collection.mutable

object FrameQueue {
  def findMaxes(array: Seq[Int], frame: Int): Seq[Int] = {
    val lastMax = array.take(frame).max
    val maxes = Seq(lastMax)

    val queue = mutable.Queue[Int](array.takeRight(array.length - frame): _*)
    for (elem <- array.takeRight(array.length - frame)){

    }
    maxes
  }
}