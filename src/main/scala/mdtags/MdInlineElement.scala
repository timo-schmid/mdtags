package mdtags

trait MdInlineElement extends MdListChild {

  def append(mdElement: MdInlineElement): List[MdInlineElement] = List(this, mdElement)

  def &(mdElement: MdInlineElement): List[MdInlineElement] = this append(mdElement)

}
