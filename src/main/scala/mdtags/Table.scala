package mdtags

class table(val headerRow: Boolean, val map: Map[Int,Map[Int,MdInlineElement]] = Map()) {

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

  private lazy val longestStringLength: Int = map.values.flatMap(_.values).seq.map(_.toMarkdown(0).length).max

  private lazy val tableRows: List[String] = map.toSeq.sortBy(_._1).map(
    _._2
      .map(
        s => {
          (s._2.toMarkdown()).padTo(colsWithLongestLength(s._1), " ").mkString
        }
      )
      .mkString("| ", " | ", " |")
  ).toList

  // private lazy val headerFieldString: String = List().padTo(colsWithLongestLength(s._1), "-").mkString

  def headerField(length: Int): String =
    List().padTo(length, "-").mkString

  def headerFields: Map[Int,String] =
    Stream
      .from(0, 1)
      .take(colsWithLongestLength.size)
      .map(i => i -> headerField(colsWithLongestLength(i)))
      .toMap

  private lazy val headerRowString: String = Stream.from(0, 1).map(colsWithLongestLength(_)).map(headerField(_)).take(map.seq(0).size).mkString("| ", " | ", " |")

  private lazy val tableRowsWithHeader: List[String] = tableRows.take(1) ++ List(headerRowString) ++ tableRows.drop(1).take(tableRows.length - 1)

  private lazy val allTableRows: List[String] = if(headerRow) tableRowsWithHeader else tableRows

  def toMarkdown: String = allTableRows.mkString("\n")

}

object table {

  private def apply(headerRow: Boolean, rows: Int, cols: Int): TableBuilder =
    new TableBuilder(headerRow, rows, cols, Map(), 0, 0)

  private def appendElement: (TableBuilder, MdInlineElement) => TableBuilder =
    (builder, element) => builder.apply(element)

  def apply(headerRow: Boolean, rows: Int, cols: Int)(fields: MdInlineElement*): table =
    fields.foldLeft[TableBuilder](apply(headerRow, rows, cols))(appendElement).build()

}
