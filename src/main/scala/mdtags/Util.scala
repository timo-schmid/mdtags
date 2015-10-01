package mdtags

private[mdtags] trait Util {

  def indent(currentIndent: Int): String =
    if(currentIndent > 0) {
      Array.fill(currentIndent)(" ").mkString("")
    } else {
      ""
    }

  def formatMarkupString(s: String, currentIndent: Int): String = {

    lazy val markupSingleLine = s

    def markupLineSeparator = {
      "\n" + indent(currentIndent + markupSep.length - 1) + "|"
    }

    def markupMultiLine(currentIndent: Int) = {
      var split = s.split("\\n").filterNot(_.trim.equals(""))
      split.mkString(markupLineSeparator)
    }

    def markupSep = if (s.contains("\"") || s.contains("\n")) markupSepEscape else markupSepNoEscape

    def markupSepEscape = "\"\"\""

    def markupSepNoEscape = "\""

    if (s.contains("\n")) {
      indent(currentIndent) + markupSep + markupMultiLine(currentIndent) + markupSep + ".stripMargin"
    } else {
      indent(currentIndent) + markupSep + markupSingleLine + markupSep
    }
  }

}
