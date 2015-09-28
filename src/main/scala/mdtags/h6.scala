package mdtags

class h6(val title: String) extends MdElement {

  override def convertToString: String = s"""## $title"""

  def convertToMarkup(indentSpaces: Int, currentIndent: Int): String =
    indent(currentIndent) + s"""h6("$title")"""

}

object h6 {

  def apply(title: String): h6 = new h6(title)

}
