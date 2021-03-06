package mdtags

private[mdtags] class list(childElements: Seq[MdListChild]) extends MdListChild with MdElementChild[list] {

  override def mdElement: list = this

  private val listPrefixChar = '*'

  private def listPrefix(listIndent: Int) = indent(listIndent, listPrefixChar + " ")

  def childMarkdown(listIndent: Int): String = childElements.map {
      _ match {
        case list: list => list.toMarkdown(listIndent + 2)
        case mdElement: MdElement => {
          listPrefix(listIndent) + mdElement.toMarkdown()
        }
      }
    }.mkString("\n")

  override def toMarkdown(listIndent: Int): String = childMarkdown(listIndent)

  override def convertToMarkup(implicit indentSpaces: Int = 2): String =
    "list(" +
      childElements.map(_.convertToMarkup(indentSpaces)).map(indent(indentSpaces, _)).mkString("\n", ",\n", "\n") +
    ")"

}

object list {

  def apply(mandatoryFirstChild: MdListChild, childs: MdListChild*): list = new list(Seq(mandatoryFirstChild) ++ childs)

}
