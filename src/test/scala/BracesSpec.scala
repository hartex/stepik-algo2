import org.scalatest._

class BracesSpec extends FlatSpec with Matchers {
  "Braces" should "find an error in right place" in {
    Braces.findError("[[sdfsdf]]sdfsdf dsf ds ()")
  }

  "Braces" should "print success when everything is fine" in {
    Braces.findError("{{sdfsd   sdf}[123123[12 3 ]  ]")
  }
}
