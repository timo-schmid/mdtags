package mdtags

private[mdtags] class list(childElements: Seq[MdListChild]) extends MdListChild with MdElementChild[list] {

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
    else
      ""
  }

  override def toMarkdown(listIndent: Int): String = childMarkdown(listIndent)

  override def convertToMarkup(implicit indentSpaces: Int = 2): String = ???

}

object list {

  def apply(mandatoryFirstChild: MdListChild, childs: MdListChild*): list = new list(Seq(mandatoryFirstChild) ++ childs)

}
