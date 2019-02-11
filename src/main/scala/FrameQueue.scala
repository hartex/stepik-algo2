package example

import scala.collection.mutable

class FrameQueue(values: List[Int], frame: Int) {
  def findMaxes(): List[Int] = {
    val frameValues = values.take(frame)
    val queue = mutable.Queue(frameValues:_*)
    val localMax = frameValues.max
    val maxes = List(localMax)

    for (i <- frame until values.length){
      val lastInQueue = queue.dequeue()
      val nextInQueue = values(i)
      if(nextInQueue > localMax )
    }

    for (i <- values.indices){
      if(i >= frame){
        val x=queue.front
        println(x)
        if(x == values(i - frame)){
          queue.dequeue
        }
      }

      while(queue.nonEmpty && queue.front < values(i)){
        queue.dequeue()
      }
      queue.enqueue(values(i))
    }


    for(int i  = 0; i < arrSize; ++i) {
      if(i >= window) {
        int x = deque.peekFirst();
        System.out.println(x);
        if(x == array[i - window]) {
          deque.pollFirst();
        }
      }

      while(!deque.isEmpty() && deque.peekLast() < array[i]) {
        deque.pollLast();
      }
      deque.addLast(array[i]);
    }

    if(!deque.isEmpty() && arrSize >= window) {
      System.out.println(deque.peekFirst());
    }
  }
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