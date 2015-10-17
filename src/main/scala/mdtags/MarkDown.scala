package mdtags

class MarkDown(val childs: Seq[MarkDownChild]) extends MdElement {

  def childMarkup(implicit indentSpaces: Int): String = {
    if(childs.isEmpty) {
      ""
    } else {
      childs.map((child) => indent(indentSpaces, child.convertToMarkup(indentSpaces))) mkString("\n", ",\n", "\n")
    }
  }

  override def toMarkdown(listIndent: Int = 0): String = childs.map(_.toMarkdown()) mkString("\n\n")

  override def convertToMarkup(implicit indentSpaces: Int = 2): String =
    "MarkDown(" +
      childMarkup +
    ")"
}

object MarkDown {

  def apply(): MarkDown = new MarkDown(Seq())

  def apply(childs: MarkDownChild*): MarkDown = new MarkDown(childs)

}
