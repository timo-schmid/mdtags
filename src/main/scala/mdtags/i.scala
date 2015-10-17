package mdtags

class i(val text: String) extends MdElement {

  lazy val sepChar = '*' // TODO could be configurable

  override def toMarkdown(listIndent: Int = 0): String = sepChar + text + sepChar

  override def convertToMarkup(implicit indentSpaces: Int): String =
    "i(\n" +
      indent(indentSpaces, "text = " + formatMarkupString(text)) + ",\n" +
    ")"

}

object i {

  def apply(text: String): i = new i(text)

}
