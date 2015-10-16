package mdtags

class hr(val separatorChar: Char = '*') extends MdElement {

  override def convertToString: String = List() padTo(3, separatorChar toString) mkString

  def markupSeparatorChar = if(separatorChar == '*') { "" } else { "separatorChar = '" + separatorChar + "'" }

  override def convertToMarkup(implicit indentSpaces: Int): String =
    "br(" + markupSeparatorChar + ")"

}

object hr {

  def apply(chr: Char = '*') = chr match {
    case '*' => new hr(chr)
    case '-' => new hr(chr)
    case '_' => new hr(chr)
    case _ => throw new IllegalArgumentException( s"The character '$chr' is not a valid character " +
                                                  s"for horizontal rules. Try '*', '-' or '_'.")
  }

}
