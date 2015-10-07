package mdtags

class link(val link: String, val mdElement: MdElement) extends MdElement {

  override def convertToString: String = s"[${mdElement.convertToString}](${link})"

  override def convertToMarkup(implicit indentSpaces: Int): String =
    "link(\n" +
    indent(indentSpaces, "link = " + formatMarkupString(link)) + ",\n" +
    indent(indentSpaces, "text = " + mdElement.convertToMarkup) + "\n" +
    ")"
}

object link {

  def apply(link: String, text: String): link = new link(link, text)

  def apply(link: String): link = apply(link, link)

  def apply(link: String, image: image): link = new link(link, image)

}
