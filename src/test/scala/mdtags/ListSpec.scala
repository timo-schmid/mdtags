package mdtags

import org.specs2.mutable.Specification

class ListSpec extends Specification {

  "A List" should {

    "render correctly" in {
      list(
        "item 1",
        "item 2",
        "item 3"
      ).toMarkdown() must equalTo(
        """* item 1
          |* item 2
          |* item 3""".stripMargin
      )
    }

    "render lists in lists correctly" in {
      list(
        "item 1",
        list(
          "sub-item 1",
          "sub-item 2"
        ),
        "item 2"
      ).toMarkdown() must equalTo(
        """* item 1
          |  * sub-item 1
          |  * sub-item 2
          |* item 2""".stripMargin
      )
    }

    "be able to contain inline elements" in {
      list(
        b("a bold text"),
        i("an italic text"),
        s("a strikethrough text"),
        "a text and" & b("a bold text")
      ).toMarkdown() must equalTo(
        """* **a bold text**
          |* *an italic text*
          |* ~~a strikethrough text~~
          |* a text and **a bold text**""".stripMargin
      )
    }

    "render scala syntax correctly" in {
      list(
        "first item",
        "second item" & b("with bold text"),
        "third item"
      ).convertToMarkup() must equalTo(
        """list(
          |  "first item",
          |  "second item" & b("with bold text"),
          |  "third item"
          |)""".stripMargin
      )

    }

  }

}
