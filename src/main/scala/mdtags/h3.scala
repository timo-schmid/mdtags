package mdtags

class h3(val title: String) extends MdElement {

  override def convertToString: String = s"""## $title"""

  def convertToMarkup(indentSpaces: Int, currentIndent: Int): String =
    indent(currentIndent) + s"""h3("$title")"""

}

object h3 {

  def apply(title: String): h3 = new h3(title)

}
