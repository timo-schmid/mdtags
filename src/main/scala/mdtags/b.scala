package mdtags

import scala.language.postfixOps

class b(val text: String) extends MdElement {

  val sepChar = '*' // TODO could be configurable

  val sep: String = pad(2, sepChar)

  override def toMarkdown(lineIntdent: Int): String = sep + text + sep

  override def convertToMarkup(implicit indentSpaces: Int): String =
    "b(" + formatMarkupString(text) + ")"

}

object b {

  def apply(text: String): b = new b(text)

}
