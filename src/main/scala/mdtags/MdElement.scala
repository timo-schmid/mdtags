package mdtags

trait MdElement extends Util {

  def convertToString: String

  def convertToMarkup(implicit indentSpaces: Int = 2): String

}
