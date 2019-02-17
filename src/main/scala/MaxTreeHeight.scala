object MaxTreeHeight {
  private class Node[T](val value: T, val parent: Node[T], var children: Seq[Node[T]])

  private def makeTree(tree: Seq[Int]): Node[Int] = {
    val mapping = tree
      .zipWithIndex
      .groupBy(_._1)
      .map(item => (item._1, item._2.map(_._2)))

    def hey(parent: Node[Int]): Node[Int] = {
      if (mapping.contains(parent.value)) {
        parent.children = mapping.getOrElse(parent.value, null).map(new Node(_, parent, null))
        parent.children.foreach(v => hey(v))
      }
      parent
    }

    hey(new Node(tree.indexOf(-1), null, null))
  }

  private def findMaxHeight(node: Node[Int]): Int = {
    var height = 1
    if (node.children != null) {
      for (a <- node.children) {
        height = height max (1 + findMaxHeight(a))
      }
    }
    height
  }

  def find(tree: Seq[Int]): Int = {
    val newTree = makeTree(tree)
    findMaxHeight(newTree)
  }
}
