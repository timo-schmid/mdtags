package mdtags

import scala.util.{Try, Success, Failure}

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
      code = exampleCode.toMarkdown()
    ),
    h2("TODO"),
    b("Easy Tasks"),
    list(
      s("Emphasis"),
      list(
        s("Bold"),
        s("Italic"),
        s("Strikethrough")
      ),
      s("Lists"),
      s("Links"),
      s("Images"),
      "Tables",
      s("Horizontal Rule"),
      s("Line Breaks"),
      s("Youtube videos")
    ),
    hr(),
    b("More advanced tasks"),
    list(
      "Create an sbt-plugin to generate the docs",
      "Test Cases",
      list(
        "Bold",
        "Italic",
        "Strikethrough",
        "Horizontal Rule",
        "Youtube videos"
      )
    ),
    h2("Build status"),
    link(
      "https://bintray.com/timo-schmid/sbt-plugins/mdtags/_latestVersion",
      image("https://api.bintray.com/packages/timo-schmid/sbt-plugins/mdtags/images/download.svg", "Download")
    ) &
    link(
      "https://travis-ci.org/timo-schmid/mdtags",
      image("https://travis-ci.org/timo-schmid/mdtags.svg?branch=master", "Build Status")
    ) &
    link(
      "https://coveralls.io/github/timo-schmid/mdtags?branch=master",
      image("https://coveralls.io/repos/timo-schmid/mdtags/badge.svg?branch=master&service=github", "Coverage Status")
    ) &
    link(
      "https://www.codacy.com/app/timo-schmid/mdtags",
      image("https://api.codacy.com/project/badge/2f0d123731dd4bcba8bbd525f0083d56", "Codacy Badge")
    )
  )

  def main(args: Array[String]): Unit = {
    writeToFile("README.md", readmeMarkdown.toMarkdown())
  }

  /**
   * Writes a string to the README.md file
   */
  private def writeToFile(file: String, text: String) = {
    val pw = new java.io.PrintWriter(file)
    Try {
      pw.write(text)
    } match {
      case Success(_) =>
      case Failure(e) => e.printStackTrace();
    }
    pw.close()
  }

}
