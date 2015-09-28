package mdtags

class MarkDown(childs: Seq[Any]) extends MdElement {

  def childToString(child: Any): String = child match {
    case mdEl: MdElement => mdEl.convertToString
    case any: Any => any.toString
  }

  def childToMarkup(child: Any, currentIndent: Int): String = child match {
    case mdEl: MdElement => mdEl.convertToMarkup(currentIndent = currentIndent)
    case s: String => indent(currentIndent) + s""""$s""""
    case any: Any => indent(currentIndent) + any.toString
  }

  def childMarkup(currentIndent: Int): String = childs.map(childToMarkup(_, currentIndent: Int)) mkString(",\n")

  override def toString: String = convertToString

  override def convertToString: String = childs.map(childToString) mkString("\n\n")

  override def convertToMarkup(indentSpaces: Int, currentIndent: Int): String = Seq(
    indent(currentIndent) + "MarkDown(",
    childMarkup(currentIndent + indentSpaces),
    indent(currentIndent) + ")"
  ) mkString("\n")

}

object MarkDown {

  def apply(): MarkDown = new MarkDown(Seq())

  def apply(childs: Any*): MarkDown = new MarkDown(childs)

}
