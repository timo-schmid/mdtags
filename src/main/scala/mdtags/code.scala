package mdtags

class code(val code: String, val syntax: Option[String]) extends MdElement {

  lazy val syntaxStr = syntax.getOrElse("")

  override def convertToString: String = s"```$syntaxStr\n" + code + "\n```"

  override def convertToMarkup(implicit indentSpaces: Int): String = {

    def syntaxLine = syntax match {
      case None => ""
      case Some(s) => indent(indentSpaces, s"""syntax = "$s",""") + "\n"
    }

    def codeAssignment = "code = "

    val indentCode = indent(codeAssignment.length, formatMarkupString(code))

    def codeLines =
      codeAssignment + indentCode.substring(codeAssignment.length)


    def indentCodeLines =
      indent(indentSpaces, codeLines) + "\n"

    "code(\n" +
      syntaxLine +
      indentCodeLines +
    ")"
  }
}

object code {

  def apply(code: String, syntax: Option[String] = None): code = new code(code, syntax)

  def apply(code: String, syntax: String): code = apply(code, Some(syntax))

}
