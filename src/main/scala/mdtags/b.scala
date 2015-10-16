package mdtags

import scala.language.postfixOps

class b(val text: String) extends MdElement {

  val sepChar = '*' // TODO could be configurable

  val sep: String = pad(2, sepChar)

  override def convertToString: String = sep + text + sep

  override def convertToMarkup(implicit indentSpaces: Int): String =
    "b(\n" +
      indent(indentSpaces, "text = " + formatMarkupString(text)) + ",\n" +
    ")"

}

object b {

  def apply(text: String): b = new b(text)

}
