package mdtags

class code(val code: String, val syntax: Option[String]) extends MdElement {

  lazy val syntaxStr = syntax.getOrElse("")

  override def convertToString: String = s"```$syntaxStr\n" + code + "\n```"

  override def convertToMarkup(indentSpaces: Int, currentIndent: Int): String = {

    def syntaxLine = syntax match {
      case None => ""
      case Some(s) => indent(currentIndent + indentSpaces) + s"""syntax = "$s",\n"""
    }
    def codeLines =
      indent(currentIndent + indentSpaces) +
      "code = " +
      formatMarkupString(code, currentIndent + indentSpaces + 7)
        .substring(currentIndent + indentSpaces + 7) +
      "\n"

    indent(currentIndent) + "code(\n" +
      syntaxLine +
      codeLines +
      indent(currentIndent) + ")"
  }
}

object code {

  def apply(code: String, syntax: Option[String] = None): code = new code(code, syntax)

  def apply(code: String, syntax: String): code = apply(code, Some(syntax))

}
