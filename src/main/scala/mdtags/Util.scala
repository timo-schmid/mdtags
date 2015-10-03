package mdtags

private[mdtags] trait Util {

  def indent(indentSpaces: Int, text: String): String = {
    def getIndentString: String =
      if(indentSpaces > 0) {
        Array.fill(indentSpaces)(" ").mkString("")
      } else {
        ""
      }
    text.split("\n").map(getIndentString + _).mkString("\n")
  }

  def formatMarkupString(s: String): String = {

    def markupMultiLine = {
      s.split("\\n").filterNot(_.trim.isEmpty).mkString("\n  |")
    }

    val markupSepEscape = "\"\"\""

    val markupSepNoEscape = "\""

    def markupSep = if (s.contains("\"") || s.contains("\n")) markupSepEscape else markupSepNoEscape

    if (s.contains("\n")) {
      markupSep + markupMultiLine + markupSep + ".stripMargin"
    } else {
      markupSep + s + markupSep
    }
  }

}
