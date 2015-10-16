package object mdtags {

  import TitleElement._

  sealed private[mdtags] trait MarkDownChild extends MdElement

  type MarkDownInlineElements = List[MdInlineElement]

  trait MdElementChild[T<:MdElement] extends MarkDownChild {

    def mdElement: T

    override def convertToString: String =
      mdElement.convertToString

    override def convertToMarkup(implicit indentSpaces: Int): String =
      mdElement.convertToMarkup(indentSpaces)

  }

  def h1(title: String): h1 = new h1(title)

  def h2(title: String): h2 = new h2(title)

  def h3(title: String): h3 = new h3(title)

  def h4(title: String): h4 = new h4(title)

  def h5(title: String): h5 = new h5(title)

  def h6(title: String): h6 = new h6(title)

  implicit class MarkDownH1Child(val mdElement: h1) extends MdElementChild[h1]

  implicit class MarkDownH2Child(val mdElement: h2) extends MdElementChild[h2]

  implicit class MarkDownH3Child(val mdElement: h3) extends MdElementChild[h3]

  implicit class MarkDownH4Child(val mdElement: h4) extends MdElementChild[h4]

  implicit class MarkDownH5Child(val mdElement: h5) extends MdElementChild[h5]

  implicit class MarkDownH6Child(val mdElement: h6) extends MdElementChild[h6]

  implicit class MarkDownCodeChild(val mdElement: code) extends MdElementChild[code] // TODO create an inline mode for code

  implicit class MarkDownHrChild(val mdElement: hr) extends MdElementChild[hr]

  implicit class MarkDownLinkChild(val mdElement: link) extends MdElementChild[link] with MdInlineElement

  implicit class MarkDownImageChild(val mdElement: image) extends MdElementChild[image] with MdInlineElement

  implicit class MarkDownBoldChild(val mdElement: b) extends MdElementChild[b] with MdInlineElement

  implicit class MarkDownItalicChild(val mdElement: i) extends MdElementChild[i] with MdInlineElement

  implicit class MarkDownStrikethroughChild(val mdElement: s) extends MdElementChild[s] with MdInlineElement

  implicit class MarkDownInlineElementChild(val mdElements: MarkDownInlineElements) extends MarkDownChild with MdInlineElement {

    override def convertToString: String =
      mdElements.map(_.convertToString).mkString(" ")

    override def convertToMarkup(implicit indentSpaces: Int): String = ???

  }

  implicit class MarkDownStringChild(s: String) extends MarkDownChild with MdInlineElement {

    def convertToString: String = s

    def convertToMarkup(implicit indentSpaces: Int): String =
      formatMarkupString(s)

  }

}
