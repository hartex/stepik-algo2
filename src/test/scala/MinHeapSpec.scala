import org.scalatest._

class MinHeapSpec extends FlatSpec with Matchers {
  "MinHeap" should "calculate permutations correctly" in {
    MinHeap.countPermutations(Seq(7, 6, 5, 4, 3, 2)) shouldBe Seq((2, 5), (1, 4), (0, 2), (2, 5))
  }
}
