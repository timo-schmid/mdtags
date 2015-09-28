package mdtags

trait MdElement {

  def convertToString: String

  def convertToMarkup(indentSpaces: Int = 2, currentIndent: Int = 0): String

  private[mdtags] def indent(currentIndent: Int): String =
    if(currentIndent > 0) {
      Array.fill(1)(" ").mkString(" ")
    } else {
      ""
    }

}
