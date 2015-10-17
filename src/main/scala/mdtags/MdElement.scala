package mdtags

trait MdElement extends Util {

  def toMarkdown(listIndent: Int = 0): String

  def convertToMarkup(implicit indentSpaces: Int = 2): String

}
