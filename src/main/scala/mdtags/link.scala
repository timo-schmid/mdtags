package mdtags

/**
 * Created by timo on 02.10.15.
 */
class link(val link: String, val text: String) extends MdElement {

  override def convertToString: String = s"[${text}](${link})"

  override def convertToMarkup(implicit indentSpaces: Int): String =
    "link(\n" +
    indent(indentSpaces, "link = " + formatMarkupString(link)) + ",\n" +
    indent(indentSpaces, "text = " + formatMarkupString(text)) + "\n" +
    ")"
}

object link {

  def apply(link: String, text: String): link = new link(link, text)

  def apply(link: String): link = apply(link, link)

}
