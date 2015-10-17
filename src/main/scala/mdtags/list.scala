package mdtags

class list(childElements: Seq[MdElement]) extends MdElement with MdElementChild[list] {

  override def mdElement = this

  val listPrefixChar = '*'

  def listPrefix(listIndent: Int) = indent(listIndent, listPrefixChar + " ")

  def childMarkdown(listIndent: Int): String = {
    if(childElements.size > 0)
      childElements.map{
        _ match {
          case list: list => list.toMarkdown(listIndent + 2)
          case mdElement: MdElement => {
            listPrefix(listIndent) + mdElement.toMarkdown()
          }
        }
      }.mkString("\n")
      // childElements.map(_.toMarkdown("")).mkString(listPrefix, "\n" + listPrefix, "")
    else
      ""
  }

  override def toMarkdown(listIndent: Int): String = childMarkdown(listIndent)

  override def convertToMarkup(implicit indentSpaces: Int = 2): String = ???

}

object list {

  def apply(): list = new list(Seq()) // is an empty constructor really useful?

  def apply(childs: MarkDownChild*): list = new list(childs)

}
