package mdtags

object Readme {

  private case class Example(title: String, text: String, markdown: MarkDown)

  // an example code
  /*
  private val examples = List(
    new Example(
      "Headers",
      "Headers are rather straightforward:",
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
  */

  val exampleCode = MarkDown(
    h1("Hello from mdtags!"),
    "Make sure to always code typesafe!",
    link("http://www.github.com/", "This project is hosted on GitHub"),
    """Feel free to add multi-line strings
    |Like this one, for example!""".stripMargin,
    "The code-element works too, but sadly it does not render correctly on github (inside anther code element).",
    /*
    code(
      code = "List(1,2,3).reverse",
      syntax = "scala"
    ),
    code(
      code = """List("foo", "bar", "baz")
               |  .reverse
               |  .mkString(" - ")""".stripMargin,
      syntax = "scala"
    ),
    */
    image("https://travis-ci.org/timo-schmid/mdtags.svg?branch=master", "Build status")
  )

  /**
   * The content that will be written to the README file,
   * defined in mdtags
   */
   private val readmeMarkdown: MarkDown = MarkDown(
     h1("mdtags - Typesafe MarkDown in Scala"),
     h2("What is mdtags?"),
     """The idea for mdtags is stolen from scala-js: It enables you to
       |write Markdown in a typesafe manner in scala.""".stripMargin,
     "Here's an example:",
     code(
       syntax = "scala",
       code = exampleCode.convertToMarkup()
     ),
     "The example code would render this MarkDown:",
     code(
       syntax = "markdown",
       code = exampleCode.convertToString
     ),
     h2("TODO"),
     """* Emphasis
       |* Lists
       |* ~~Links~~
       |* Images
       |* Tables
       |* Horizontal Rule
       |* Line Breaks
       |* Youtube videos
       |* Create an SBT-Plugin to generate docs""".stripMargin,
     h2("Build status"),
     link(
       "https://travis-ci.org/timo-schmid/mdtags",
       image("https://travis-ci.org/timo-schmid/mdtags.svg?branch=master", "Build Status")
     ) &
     link(
        "https://coveralls.io/github/timo-schmid/mdtags?branch=master",
        image("https://coveralls.io/repos/timo-schmid/mdtags/badge.svg?branch=master&service=github", "Coverage Status")
     )
   )

  def main(args: Array[String]): Unit = {
    writeToReadme(readmeMarkdown.convertToString)
  }

  /**
   * Writes a string to the README.md file
   */
  private def writeToReadme(text: String) = {
    val pw = new java.io.PrintWriter("README.md")
    try {
      pw.write(text)
    } finally {
      pw.close
    }
  }

}
