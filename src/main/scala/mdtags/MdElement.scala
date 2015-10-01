package mdtags

trait MdElement extends Util {

  def convertToString: String

  def convertToMarkup(indentSpaces: Int = 2, currentIndent: Int = 0): String

}
