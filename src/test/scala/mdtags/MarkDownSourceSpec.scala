package mdtags

import org.specs2.mutable.Specification

class MarkDownSourceSpec extends Specification {

  "Empty MarkDown" should {

    "return an empty string" in {
      MarkDown().convertToMarkup() must equalTo("MarkDown()")
    }

  }

  "Non-Empty MarkDown" should {

    "return the appropriate Source Code" in {
      val longStringDelim = "\"\"\""
      MarkDown(
        h1("A title"),
        "A string",
        h2("A level-2 title"),
        h3("A level-2 title"),
        h4("A level-2 title"),
        h5("A level-2 title"),
        h6("A level-2 title"),
        """A multi-line string
          |Lets challenge the code!"""
          .stripMargin,
        code(
          syntax = "COBOL",
          code = "MOVE 0 TO AI-RC"
        ),
        code(
          code = "MOVE 1 TO AI-RC"
        ),
        mdtags.link(
          link = "http://www.google.com/",
          text = "Google"
        ),
        image(
          imageSrc = "my-image.png",
          altText = "My image"
        )
      ).convertToMarkup must equalTo(
        s"""MarkDown(
           |  h1("A title"),
           |  "A string",
           |  h2("A level-2 title"),
           |  h3("A level-2 title"),
           |  h4("A level-2 title"),
           |  h5("A level-2 title"),
           |  h6("A level-2 title"),
           |  ${longStringDelim}A multi-line string
           |    %Lets challenge the code!${longStringDelim}.stripMargin,
           |  code(
           |    syntax = "COBOL",
           |    code = "MOVE 0 TO AI-RC"
           |  ),
           |  code(
           |    code = "MOVE 1 TO AI-RC"
           |  ),
           |  link(
           |    link = "http://www.google.com/",
           |    text = "Google"
           |  ),
           |  image(
           |    imageSrc = "my-image.png",
           |    altText = "My image"
           |  )
           |)"""
           .stripMargin.replace("%", "|")
      )
    }

  }

}
