package mdtags

class h1(val title: String) extends MdElement {

  override def convertToString: String = s"""# $title"""

  def convertToMarkup(indentSpaces: Int, currentIndent: Int): String =
    indent(currentIndent) + s"""h1("$title")"""

}

object h1 {

  def apply(title: String): h1 = new h1(title)

}

