package mdtags

import org.specs2.mutable.Specification

class EmphasisSpec extends Specification {

  "the b tag" should {

    "render bold text correctly" in {

      b("a bold text").toMarkdown() must equalTo("**a bold text**")

    }

    "render the correct scala syntax" in {

      b("a bold text").convertToMarkup() must equalTo("""b("a bold text")""")

    }

  }

  "the i tag" should {

    "render italic text correctly" in {

      i("an italic text").toMarkdown() must equalTo("*an italic text*")

    }

    "render the correct scala syntax" in {

      i("an italic text").convertToMarkup() must equalTo("""i("an italic text")""")

    }

  }

  "the s tag" should {

    "render strikethrough text correctly" in {

      s("a strikethrough text").toMarkdown() must equalTo("~~a strikethrough text~~")

    }

    "render the correct scala syntax" in {

      s("a strikethrough text").convertToMarkup() must equalTo("""s("a strikethrough text")""")

    }

  }

}
