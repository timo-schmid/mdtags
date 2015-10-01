package mdtags

class MarkDown(childs: Seq[MarkDownChild]) extends MdElement {

  def childMarkup(indentSpaces: Int, currentIndent: Int): String = {
    val childMu = childs.map(_.convertToMarkup(indentSpaces, currentIndent)) mkString(",\n")
    if(childMu.isEmpty) {
      ""
    } else {
      "\n" + childMu + "\n"
    }
  }

  override def toString: String = convertToString

  override def convertToString: String = childs.map(_.convertToString) mkString("\n\n")

  override def convertToMarkup(indentSpaces: Int = 2, currentIndent: Int = 0): String =
    indent(currentIndent) + "MarkDown(" +
    childMarkup(indentSpaces, currentIndent + indentSpaces) +
    indent(currentIndent) + ")"

}

object MarkDown {

  def apply(): MarkDown = new MarkDown(Seq())

  def apply(childs: MarkDownChild*): MarkDown = new MarkDown(childs)

}
