package mdtags

class s(val text: String) extends MdElement {

  val sepChar = '~'

  val sep: String = pad(2, sepChar)

  override def toMarkdown(listIndent: Int = 0): String = sep + text + sep

  override def convertToMarkup(implicit indentSpaces: Int): String =
    "strike(\n" +
      indent(indentSpaces, "text = " + formatMarkupString(text)) + ",\n" +
    ")"

}

object s {

  def apply(text: String): s = new s(text)

}
