package mdtags

/**
 * Represents any title
 */
class TitleElement[T](val title: String, val titleLevel: Int) extends MdElement {

  lazy val hashes = (for(i <- 0 to titleLevel) yield "").mkString("#")

  override def convertToString: String = s"""${hashes} ${title}"""

  override def convertToMarkup(implicit indentSpaces: Int): String =
    s"""h${titleLevel}("$title")"""
}

/**
 * Definitions for each specific title
 */
object TitleElement {

  class h1(title: String) extends TitleElement(title, 1)

  class h2(title: String) extends TitleElement(title, 2)

  class h3(title: String) extends TitleElement(title, 3)

  class h4(title: String) extends TitleElement(title, 4)

  class h5(title: String) extends TitleElement(title, 5)

  class h6(title: String) extends TitleElement(title, 6)

}
