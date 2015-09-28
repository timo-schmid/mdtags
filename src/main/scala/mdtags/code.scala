package mdtags

class code(val code: String, val syntax: Option[String]) extends MdElement {

  lazy val syntaxStr = syntax.getOrElse("")

  lazy val syntaxMarkupStr = syntax match {
    case None => "None"
    case Some(s) => s""""\"$s\""""
  }

  override def convertToString: String = s"""```$syntaxStr
                                           |$code
                                           |```""".stripMargin

  override def convertToMarkup(indentSpaces: Int, currentIndent: Int): String =
    indent(currentIndent) +
    s"""code(text = "$code"[, syntax = $syntaxMarkupStr])"""

}

object code {

  def apply(code: String, syntax: Option[String] = None): code = new code(code, syntax)

  def apply(code: String, syntax: String): code = apply(code, Some(syntax))

}
