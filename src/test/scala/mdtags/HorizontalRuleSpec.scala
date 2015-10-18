package mdtags

import org.specs2.mutable.Specification

class HorizontalRuleSpec extends Specification {

  "A horizontal rule" should {

    "render correctly" in {

      hr().toMarkdown() must equalTo("***")

    }

    "render correctly using dashes" in {

      hr('-').toMarkdown() must equalTo("---")

    }

    "render correctly using underscores" in {

      hr('_').toMarkdown() must equalTo("___")

    }

    "render the correct scala syntax with default args" in {

      hr().convertToMarkup must equalTo("hr()")

    }

    "render the correct scala syntax with a dash" in {

      hr('-').convertToMarkup must equalTo("hr('-')")

    }

    "throw an exception if an illegal character is passed" in {

      hr('&') must throwAn[IllegalArgumentException]

    }

  }

}
