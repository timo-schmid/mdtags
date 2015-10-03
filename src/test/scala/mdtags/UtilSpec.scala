package mdtags

class UtilSpec extends UnitSpec with Util {

  "Empty string" should "return two quotation marks" in {
    formatMarkupString("") should be ("\"\"")
  }

  "Indent a string 0 spaces" should "return the same string" in {
    indent(0, "A simple string") should be ("A simple string")
  }

}