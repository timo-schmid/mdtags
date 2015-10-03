package mdtags

class MarkDown(childs: Seq[MarkDownChild]) extends MdElement {

  def childMarkup(implicit indentSpaces: Int): String = {
    if(childs.isEmpty) {
      ""
    } else {
      childs.map((child) => indent(indentSpaces, child.convertToMarkup(indentSpaces))) mkString("\n", ",\n", "\n")
    }
  }

  override def toString: String = convertToString

  override def convertToString: String = childs.map(_.convertToString) mkString("\n\n")

  override def convertToMarkup(implicit indentSpaces: Int = 2): String =
    "MarkDown(" +
      childMarkup +
    ")"
}

object MarkDown {

  def apply(): MarkDown = new MarkDown(Seq())

  def apply(childs: MarkDownChild*): MarkDown = new MarkDown(childs)

}
