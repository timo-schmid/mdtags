package mdtags

class MdTagsSpec extends UnitSpec {

  "Empty MarkDown" should "return an empty string" in {
    MarkDown().toString() should be ("")
  }

  "MarkDown can have a h1 title and" should "return the appropriate MarkDown" in {
    MarkDown(
      h1("Hello MdTags")
    ).toString() should be ("# Hello MdTags")
  }

  "MarkDown can have a h2 title and" should "return the appropriate MarkDown" in {
    MarkDown(
      h2("So we meet again, MdTags...")
    ).toString() should be ("## So we meet again, MdTags...")
  }

  "MarkDown can have a h1 and h2 title and" should "return the appropriate MarkDown" in {
    MarkDown(
      h1("This example uses varargs"),
      h2("See the method MarkDown#apply() for as an example")
    ).toString() should be ("""# This example uses varargs
                            |
                            |## See the method MarkDown#apply() for as an example""".stripMargin)
  }

  "MarkDown can have a text element and" should "return the text" in {
    MarkDown(
      "This is just plaintext, without special formatting."
    ).toString() should be ("This is just plaintext, without special formatting.")
  }

  "MarkDown can have titles and texts combined and" should "return the appropriate MarkDown" in {
    MarkDown(
      h1("The first title"),
      h2("The first subtitle"),
      "This is the first paragraph.",
      h2("This is the second subtitle"),
      "This is the second paragraph."
    ).toString() should be ("""# The first title
                              |
                              |## The first subtitle
                              |
                              |This is the first paragraph.
                              |
                              |## This is the second subtitle
                              |
                              |This is the second paragraph.""".stripMargin)
  }

}
