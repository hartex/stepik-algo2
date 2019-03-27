import scala.collection.mutable.ListBuffer

case class Node(key: Int, index: Int, left: Int, right: Int)

object WalkTree {

  def inOrder(nodes: Seq[Node]): Seq[Node] = {
    def walk(nodes: Seq[Node], currentNode: Node, result: ListBuffer[Node]): Unit = {
      if (currentNode.left != -1) {
        walk(nodes, nodes(currentNode.left), result)
      }
      result += currentNode
      if (currentNode.right != -1) {
        walk(nodes, nodes(currentNode.right), result)
      }
    }

    val result = ListBuffer[Node]()
    walk(nodes, nodes.head, result)
    result
  }

  def postOrder(nodes: Seq[Node]): Seq[Node] = {
    def walk(nodes: Seq[Node], currentNode: Node, result: ListBuffer[Node]): Unit = {
      if (currentNode.left != -1) {
        walk(nodes, nodes(currentNode.left), result)
      }
      if (currentNode.right != -1) {
        walk(nodes, nodes(currentNode.right), result)
      }
      result += currentNode
    }

    val result = ListBuffer[Node]()
    walk(nodes, nodes.head, result)
    result
  }

  def preOrder(nodes: Seq[Node]): Seq[Node] = {
    def walk(nodes: Seq[Node], currentNode: Node, result: ListBuffer[Node]): Unit = {
      result += currentNode
      if (currentNode.left != -1) {
        walk(nodes, nodes(currentNode.left), result)
      }
      if (currentNode.right != -1) {
        walk(nodes, nodes(currentNode.right), result)
      }
    }

    val result = ListBuffer[Node]()
    walk(nodes, nodes.head, result)
    result
  }
}
