import scala.collection.mutable

class PhoneBook {
  val table = new Array[String](10000000)

  def add(number: Int, name: String): Unit = {
    table(number) = name
  }

  def del(number: Int): Unit = {
    if (table(number) != null) {
      table(number) = null
    }
  }

  def find(number: Int): String = {
    if (table(number) == null) {
      "not found"
    } else {
      table(number)
    }
  }
}

object PhoneBook {
  def executeTasks(tasks: Seq[String]): Seq[String] = {
    val book = new PhoneBook
    val results = mutable.ListBuffer[String]()
    for (task <- tasks) {
      task match {
        case d if d startsWith "del" => book.del(d.split(" ")(1).toInt)
        case a if a startsWith "add" => book.add(a.split(" ")(1).toInt, a.split(" ")(2))
        case f if f startsWith "find" => results += book.find(f.split(" ")(1).toInt)
      }
    }
    results.toList
  }
}