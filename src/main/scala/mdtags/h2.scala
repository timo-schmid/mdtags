package mdtags

class h2(val title: String) extends MdElement {

  override def convertToString: String = s"""## $title"""

  def convertToMarkup(indentSpaces: Int, currentIndent: Int): String =
    indent(currentIndent) + s"""h2("$title")"""

}

object h2 {

  def apply(title: String): h2 = new h2(title)

}
