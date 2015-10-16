package mdtags

class code(val code: String, val syntax: Option[String]) extends MdElement {

  lazy val syntaxStr = syntax.getOrElse("")

  override def convertToString: String =
    s"```$syntaxStr\n" +
      code.replaceAll("```", "````") + // replace all ``` with 4 ticks, to not allow the code to accidentlay end this code block
      "\n```"

  override def convertToMarkup(implicit indentSpaces: Int): String = {

    def syntaxLine = syntax match {
      case None => ""
      case Some(s) => indent(indentSpaces, s"""syntax = "$s",""") + "\n"
    }

    val assignmentStr = "code = "

    val indentCode = indent(
      assignmentStr.length,
      formatMarkupString(code)
    )

    def scalaLines =
      assignmentStr + indentCode.substring(assignmentStr.length)


    def indentScalaLines =
      indent(indentSpaces, scalaLines) + "\n"

    "code(\n" +
      syntaxLine +
      indentScalaLines +
    ")"
  }
}

object code {

  def apply(code: String, syntax: Option[String] = None): code = new code(code, syntax)

  def apply(code: String, syntax: String): code = apply(code, Some(syntax))

}
