sealed trait FindResult

object Yes extends FindResult {
  override def toString: String = "yes"
}

object No extends FindResult {
  override def toString: String = "no"
}

class ChainedHashTable(m: Int) {

  import ChainedHashTable.hash

  val table: Array[List[String]] = (for (_ <- 0 until m) yield List[String]()).toArray

  def add(strToAdd: String): Unit = {
    val index = hash(strToAdd, m)
    val bucket = table(index)
    if (!bucket.contains(strToAdd)) {
      table(index) = strToAdd :: bucket
    }
  }

  def del(strToDel: String): Unit = {
    val index = hash(strToDel, m)
    val bucket = table(index)
    if (bucket.contains(strToDel)) {
      table(index) = bucket.filter(_ != strToDel)
    }
  }

  def find(strToDel: String): FindResult = {
    val index = hash(strToDel, m)
    val bucket = table(index)
    if (bucket.contains(strToDel)) Yes
    else No
  }

  def check(index: Int): String = {
    val bucket = table(index)
    if (bucket.isEmpty) ""
    else bucket mkString " "
  }
}

object ChainedHashTable {
  val X = 263
  val P = 1000000007

  def pow(index: Int): Long =
    (0 until index).foldLeft(1l)((accum, _) => (accum * X) % P)

  def hash(string: String, m: Int): Int = {
    val code = string.zipWithIndex.foldLeft(0l)((hashCode, value) => {
      val (ch, index) = value
      (((hashCode + (ch * pow(index))) % P) + P) % P
    })
    (code % m).toInt
  }

  def executeTasks(m: Int, tasks: Seq[String]): Seq[String] = {
    val table = new ChainedHashTable(m)
    val results = scala.collection.mutable.ListBuffer[String]()

    for (task <- tasks) {
      task match {
        case d if d startsWith "del" => table.del(d.split(" ")(1))
        case a if a startsWith "add" => table.add(a.split(" ")(1))
        case f if f startsWith "find" => results += table.find(f.split(" ")(1)).toString
        case c if c startsWith "check" => results += table.check(c.split(" ")(1).toInt)
      }
    }
    results.toList
  }
}
