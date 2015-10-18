package mdtags

import org.specs2.mutable._

class TableSpec extends Specification {

  "Table" should {

    "render correctly, without a header" in {

      table(false, 3, 2)(
        "1 / 1", "1 / 2",
        "2 / 1", "2 / 2",
        "3 / 1", "3 / 2"
      ).toMarkdown() must equalTo(
        """| 1 / 1 | 1 / 2 |
          &| 2 / 1 | 2 / 2 |
          &| 3 / 1 | 3 / 2 |""".stripMargin('&')
      )

    }

    "render correctly, with a header" in {

      table(true, 2, 2)(
        "1 / 1", "1 / 2",
        "2 / 1", "2 / 2",
        "3 / 1", "3 / 2"
      ).toMarkdown() must equalTo(
        """| 1 / 1 | 1 / 2 |
          &| ----- | ----- |
          &| 2 / 1 | 2 / 2 |
          &| 3 / 1 | 3 / 2 |""".stripMargin('&')
      )

    }

    "adjust the field size correctly to the longest field" in {

      table(true, 2, 2)(
        "short", "short",
        "short", "looooooooooooooong",
        "short", "short"
      ).toMarkdown() must equalTo(
        """| short | short              |
          &| ----- | ------------------ |
          &| short | looooooooooooooong |
          &| short | short              |""".stripMargin('&')
      )

    }

    "support all types of inline elements" in {

      table(false, 2, 2)(
        b("bold"), i("italic"),
        s("strikethrough"), "an element" & b("with a bold string")
      ).toMarkdown() must equalTo(
        """| **bold**          | *italic*                          |
          &| ~~strikethrough~~ | an element **with a bold string** |""".stripMargin('&')
      )

    }

    "throw an exeption when not enough fields are used" in {

      table(true, 2, 2)(
        "row 1 / col 1", "row 1 / col2",
        "row 2 / col 1" /* this field is missing */
      ).toMarkdown() must throwA[IllegalStateException]

    }

    "throw an exeption when too many fields are used" in {

      table(false, 2, 2)(
        "row 1 / col 1", "row 1 / col2",
        "row 2 / col 1", "row 2 / col2",
        "row 3 / col 1" // this field is too much
      ).toMarkdown() must throwA[IllegalStateException]

    }

  }

}
