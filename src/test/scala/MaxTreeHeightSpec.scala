import org.scalatest._

class MaxTreeHeightSpec extends FlatSpec with Matchers {
  "Solution" should "calculate tree height correctly" in {
    MaxTreeHeight.find(Seq(9, 7, 5, 5, 2, 9, 9, 9, 2, -1)) shouldBe 4
  }
}
