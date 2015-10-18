package mdtags

import org.specs2.mutable.Specification

class YoutubeSpec extends Specification {

  "The youtube tag" should {

    "must render correctly" in {

      youtube("kkTFx3-duc8").toMarkdown() must equalTo(
        "[![YouTube video #kkTFx3-duc8](http://img.youtube.com/vi/kkTFx3-duc8/0.jpg)](http://www.youtube.com/watch?v=kkTFx3-duc8)")

    }

  }

}
