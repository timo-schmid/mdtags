package mdtags

class h5(val title: String) extends MdElement {

  override def convertToString: String = s"""## $title"""

  def convertToMarkup(indentSpaces: Int, currentIndent: Int): String =
    indent(currentIndent) + s"""h5("$title")"""

}

object h5 {

  def apply(title: String): h5 = new h5(title)

}
