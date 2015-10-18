package mdtags

class table(val headerRow: Boolean, val map: Map[Int,Map[Int,MdInlineElement]] = Map()) extends MdElement {

  private lazy val colsAsStrings: Map[Int, Map[Int, String]] = map.map {
    case (k, v) => (k, v.map {
      case (kk, vv) => (kk, vv.toMarkdown())
    })
  }

  private lazy val colsAsStringLengths: Map[Int, Map[Int, Int]] = colsAsStrings.map {
    case (k, v) => (k, v.map {
      case (kk, vv) => (kk, vv.length)
    })
  }

  private lazy val colLengthWithIndex: Seq[(Int,Int)] = colsAsStringLengths.values.flatten.toSeq

  private lazy val colsWithLongestLength = colLengthWithIndex.groupBy(_._1).map {
    case (k, v) => (k, v.map(_._2).max)
  }

  private lazy val tableRows: List[String] = map.toSeq.sortBy(_._1).map(
    _._2
      .map(
        s => {
          (s._2.toMarkdown()).padTo(colsWithLongestLength(s._1), " ").mkString
        }
      )
      .mkString("| ", " | ", " |")
  ).toList

  private def headerField(length: Int): String =
    List().padTo(length, "-").mkString

  private lazy val headerRowString: String = Stream.from(0, 1).map(colsWithLongestLength(_)).map(headerField(_)).take(map.seq(0).size).mkString("| ", " | ", " |")

  private lazy val tableRowsWithHeader: List[String] = tableRows.take(1) ++ List(headerRowString) ++ tableRows.drop(1).take(tableRows.length - 1)

  private lazy val allTableRows: List[String] = if(headerRow) tableRowsWithHeader else tableRows

  override def toMarkdown(listIndent: Int = 0): String = allTableRows.mkString("\n")

  private lazy val rows = if(headerRow) map.size - 1 else map.size

  private lazy val cols = map(0).size

  private def rowMarkup(indentSpaces: Int) = map.map {
    _._2.map(_._2.convertToMarkup(indentSpaces)).mkString(", ")
  }.map {
    indent(indentSpaces, _)
  }.mkString("\n", ",\n", "\n")

  override def convertToMarkup(implicit indentSpaces: Int = 2): String =
    s"table(${headerRow}, ${rows}, ${cols})(" +
      rowMarkup(indentSpaces) +
    s")"

}

object table {

  private def apply(headerRow: Boolean, rows: Int, cols: Int): TableBuilder =
    new TableBuilder(headerRow, rows, cols, Map(), 0, 0)

  private def appendElement: (TableBuilder, MdInlineElement) => TableBuilder =
    (builder, element) => builder.apply(element)

  def apply(headerRow: Boolean, rows: Int, cols: Int)(fields: MdInlineElement*): table =
    fields.foldLeft[TableBuilder](apply(headerRow, rows, cols))(appendElement).build()

}
