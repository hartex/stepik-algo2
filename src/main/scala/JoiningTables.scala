import java.util

sealed trait Table

final case class Link(link: Table) extends Table

final case class ValueTable(value: Array[Int]) extends Table

object JoiningTables {

  case class Changes(dest: Int, source: Int)

  import scala.io.StdIn

  private def revealSymlink(table: Table): ValueTable = {
    table match {
      case Link(link) => revealSymlink(link)
      case v @ ValueTable(_) => v
    }
  }

  def main(args: Array[String]): Unit = {
    val nAndM = StdIn.readLine().split(" ").toList.map(_.toInt) match {
      case first :: second :: Nil => (first, second)
      case _ => throw new RuntimeException
    }

    val table: Array[Table] = StdIn.readLine().split(" ").map(v => ValueTable(Array(v.toInt)))
    val operations = Iterator.continually({
      val line = StdIn.readLine().split(" ")
      Changes(line(0).toInt, line(1).toInt)
    }).take(nAndM._2).toList

    operations.foreach { op =>
      val destIndex = op.dest - 1
      val sourceIndex = op.source - 1
      val dest = revealSymlink(table(destIndex))
      dest.value.update()
      val source = revealSymlink(table(sourceIndex))
      if (dest.ne(source)) {
        table.update(destIndex, source)
        table.update(sourceIndex, Link(source))
      }
    }

    table.foreach(println)
  }
}
