package mdtags

class h4(val title: String) extends MdElement {

  override def convertToString: String = s"""## $title"""

  def convertToMarkup(indentSpaces: Int, currentIndent: Int): String =
    indent(currentIndent) + s"""h4("$title")"""

}

object h4 {

  def apply(title: String): h4 = new h4(title)

}
