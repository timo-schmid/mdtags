package mdtags

object ProjectReadme {

  def main(args: Array[String]): Unit = {

    // helper to write the content to the actual readme
    def writeToReadme(text: String) = {
      val pw = new java.io.PrintWriter("README.md")
      try {
        pw.write(text)
      } finally {
        pw.close
      }
    }

    case class Example(title: String, text: String, markdown: MarkDown)

    // an example code
    val examples = List(
      new Example(
        "Titles",
        "Titles are rather straightforward:",
        MarkDown(
          h1("Title - Level 1"),
          h2("Title - Level 2"),
          h3("Title - Level 3"),
          h4("Title - Level 4"),
          h5("Title - Level 5"),
          h6("Title - Level 6")
        )
      )
    )
    val exampleCode = MarkDown(
      h1("Hello from mdtags!"),
      "Make sure to always code typesafe!"
    )
    val readmeMarkdown: MarkDown = MarkDown(
      h1("mdtags - Typesafe MarkDown in Scala"),
      h2("What is mdtags?"),
      """The idea for mdtags is stolen from scala-js: It enables you to
        |write Markdown in a typesafe manner in scala.""".stripMargin,
      """Here's an example:""",
      code(
        syntax = "markdown",
        code = exampleCode.convertToMarkup()
      )
    )
    writeToReadme(readmeMarkdown.convertToString)
  }

}
