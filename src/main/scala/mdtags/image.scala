package mdtags

class image(val imageSrc: String, val altText: String) extends MdElement {

  override def convertToString: String = s"![${altText}](${imageSrc})"

  override def convertToMarkup(implicit indentSpaces: Int): String =
    "image(\n" +
    indent(indentSpaces, "imageSrc = " + formatMarkupString(imageSrc)) + ",\n" +
    indent(indentSpaces, "altText = " + formatMarkupString(altText)) + "\n" +
    ")"
}

object image {

  def apply(imageSrc: String, altText: String): image = new image(imageSrc, altText)

}
