package mdtags

private[mdtags] class TableBuilder( val headerRow: Boolean,
                    val rows: Int,
                    val cols: Int,
                    val map: Map[Int,Map[Int,MdInlineElement]] = Map(),
                    val currentRow: Int = 0,
                    val currentCol: Int = 0) {

  if(rows < 1) {
    throw new IllegalArgumentException("Tables must have at least one row")
  }

  if(cols < 1) {
    throw new IllegalArgumentException("Tables must have at least one column")
  }

  private lazy val headerCols = if(headerRow) cols else 0

  private lazy val expectedCols = rows * cols + headerCols

  private lazy val actualCols = map.foldLeft(0)(_ + _._2.size)

  private lazy val canBuild = expectedCols == actualCols

  private lazy val maxRows = if(headerRow) rows + 1 else rows

  private def nextMap(mdInlineElement: MdInlineElement): Map[Int,Map[Int,MdInlineElement]] = {
    def subMap = map.getOrElse(currentRow, Map()) + ((currentCol, mdInlineElement))
    map + ((currentRow, subMap))
  }

  private def nextCol: Int = if(currentCol == cols - 1) 0 else currentCol + 1

  private def nextRow: Int = if(currentCol == cols - 1) currentRow + 1 else currentRow

  def apply(mdInlineElement: MdInlineElement): TableBuilder =
    new TableBuilder(headerRow, rows, cols, nextMap(mdInlineElement), nextRow, nextCol)

  def build(): table = if(canBuild) new table(headerRow, map) else throw new IllegalStateException(s"Cannot build table: expected ${expectedCols} but got ${actualCols}")

}
