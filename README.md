# mdtags - Typesafe MarkDown in Scala

## What is mdtags?

The idea for mdtags is stolen from scala-js: It enables you to
write Markdown in a typesafe manner in scala.

Here's an example:

```scala
MarkDown(
  h1("Hello from mdtags!"),
  "Make sure to always code typesafe!",
  link(
    link = "http://www.github.com/",
    text = "This project is hosted on GitHub"
  ),
  """Feel free to add multi-line strings
    |Like this one, for example!""".stripMargin,
  "The code-element works too, but sadly it does not render correctly on github (inside anther code element).",
  image(
    imageSrc = "https://travis-ci.org/timo-schmid/mdtags.svg?branch=master",
    altText = "Build status"
  )
)
```

The example code would render this MarkDown:

```markdown
# Hello from mdtags!

Make sure to always code typesafe!

[This project is hosted on GitHub](http://www.github.com/)

Feel free to add multi-line strings
Like this one, for example!

The code-element works too, but sadly it does not render correctly on github (inside anther code element).

![Build status](https://travis-ci.org/timo-schmid/mdtags.svg?branch=master)
```

## TODO

**Easy Tasks**

* ~~Emphasis~~
  * ~~Bold~~
  * ~~Italic~~
  * ~~Strikethrough~~
* ~~Lists~~
* ~~Links~~
* ~~Images~~
* Tables
* ~~Horizontal Rule~~
* ~~Line Breaks~~
* ~~Youtube videos~~

***

**More advanced tasks**

* Create an sbt-plugin to generate the docs
* Test Cases
  * Bold
  * Italic
  * Strikethrough
  * Horizontal Rule
  * Youtube videos

## Build status

[![Download](https://api.bintray.com/packages/timo-schmid/sbt-plugins/mdtags/images/download.svg)](https://bintray.com/timo-schmid/sbt-plugins/mdtags/_latestVersion) [![Build Status](https://travis-ci.org/timo-schmid/mdtags.svg?branch=master)](https://travis-ci.org/timo-schmid/mdtags) [![Coverage Status](https://coveralls.io/repos/timo-schmid/mdtags/badge.svg?branch=master&service=github)](https://coveralls.io/github/timo-schmid/mdtags?branch=master) [![Codacy Badge](https://api.codacy.com/project/badge/2f0d123731dd4bcba8bbd525f0083d56)](https://www.codacy.com/app/timo-schmid/mdtags)