package mdtags

import org.specs2.mutable.Specification

class UtilSpec extends Specification with Util {

  "Empty string" should {

    "return two quotation marks" in {

      formatMarkupString("") must equalTo("\"\"")

    }

  }

  "Indent a string 0 spaces" should {

    "return the same string" in {

      indent(0, "A simple string") must equalTo("A simple string")

    }

  }

}