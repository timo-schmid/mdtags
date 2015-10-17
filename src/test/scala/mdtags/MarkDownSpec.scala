package mdtags

class MarkDownSpec extends UnitSpec {

  "Empty MarkDown" should "return an empty string" in {
    MarkDown().toMarkdown() should be ("")
  }

  "MarkDown can have a h1 title and" should "return the appropriate MarkDown" in {
    MarkDown(
      h1("Hello MdTags")
    ).toMarkdown() should be ("# Hello MdTags")
  }

  "MarkDown can have a h2 title and" should "return the appropriate MarkDown" in {
    MarkDown(
      h2("So we meet again, MdTags...")
    ).toMarkdown() should be ("## So we meet again, MdTags...")
  }

  "MarkDown can have a h1 and h2 title and" should "return the appropriate MarkDown" in {
    MarkDown(
      h1("This example uses varargs"),
      h2("See the method MarkDown#apply() for as an example")
    ).toMarkdown() should be ("""# This example uses varargs
                              |
                              |## See the method MarkDown#apply() for as an example""".stripMargin)
  }

  "MarkDown can have a text element and" should "return the text" in {
    MarkDown(
      "This is just plaintext, without special formatting."
    ).toMarkdown() should be ("This is just plaintext, without special formatting.")
  }

  "MarkDown can have titles and texts, etc combined and" should "return the appropriate MarkDown" in {
    MarkDown(
      h1("The first title"),
      h2("The first subtitle"),
      "This is the first paragraph.",
      h2("This is the second subtitle"),
      "This is the second paragraph.",
      h3("Level 3 Title"),
      h4("Level 4 Title"),
      h5("Level 5 Title"),
      h6("Level 6 Title"),
      link("http://www.google.com/", "Google"),
      link("http://www.gmail.com/"),
      image("my-image.png", "My image")
    ).toMarkdown() should be ("""# The first title
                              |
                              |## The first subtitle
                              |
                              |This is the first paragraph.
                              |
                              |## This is the second subtitle
                              |
                              |This is the second paragraph.
                              |
                              |### Level 3 Title
                              |
                              |#### Level 4 Title
                              |
                              |##### Level 5 Title
                              |
                              |###### Level 6 Title
                              |
                              |[Google](http://www.google.com/)
                              |
                              |[http://www.gmail.com/](http://www.gmail.com/)
                              |
                              |![My image](my-image.png)""".stripMargin)
  }

  "MarkDown can contain code elements and" should "return the appropriate MarkDown" in {
    MarkDown(
      code(
        syntax = "java",
        code = """class Main {
                 |    public static void main(String[] args) {
                 |        System.out.println(args.length);
                 |    }
                 |}""".stripMargin)
    ).toMarkdown() should be (
      """```java
        |class Main {
        |    public static void main(String[] args) {
        |        System.out.println(args.length);
        |    }
        |}
        |```""".stripMargin)
  }

}
