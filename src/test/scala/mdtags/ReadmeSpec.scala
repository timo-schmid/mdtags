package mdtags

class ReadmeSpec extends UnitSpec with Util {

  "README" should "contain example code" in {
    Readme.exampleCode.childs.size should be (6)
  }

}
