import org.scalatest._

class PhoneBookSpec extends FlatSpec with Matchers {
  "PhoneBook" should "work correctly" in {
    PhoneBook.executeTasks(
      Seq("add 911 police",
        "add 76213 Mom",
        "add 17239 Bob",
        "find 76213",
        "find 910",
        "find 911",
        "del 910",
        "del 911",
        "find 911",
        "find 76213",
        "add 76213 daddy",
        "find 76213")) shouldBe
      Seq("Mom",
        "not found",
        "police",
        "not found",
        "Mom",
        "daddy")
  }
}