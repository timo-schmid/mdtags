package mdtags

import org.specs2.mutable.Specification

class ReadmeSpec extends Specification {

  "README" should {

    "contain example code" in {
      Readme.exampleCode.childs.size must equalTo(6)
    }

  }

}
