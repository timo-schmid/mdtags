package mdtags

/**
 * Created by timo on 16.10.15.
 */
trait MdInlineElement extends MdElement {

  def append(mdElement: MdInlineElement): List[MdInlineElement] = List(this, mdElement)

  def &(mdElement: MdInlineElement): List[MdInlineElement] = this append(mdElement)

}
