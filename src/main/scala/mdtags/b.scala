package mdtags

class b(val text: String) extends MdElement {

  val sepChar = '*' // TODO could be configurable

  val sep: String = List() padTo(2, sepChar toString) mkString

  override def convertToString: String = sep + text + sep

  override def convertToMarkup(implicit indentSpaces: Int): String =
    "b(\n" +
      indent(indentSpaces, "text = " + formatMarkupString(text)) + ",\n" +
    ")"

}

object b {

  def apply(text: String) = new b(text)

}