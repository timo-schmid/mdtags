package mdtags

object youtube {

  def apply(videoId: String, altText: String): link = link(
    s"http://www.youtube.com/watch?v=$videoId",
    image(
      s"http://img.youtube.com/vi/$videoId/0.jpg",
      altText
    )
  )

  def apply(videoId: String): link = apply(videoId, s"YouTube video #$videoId")

}
