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
  "The code-element works too, but it does not correctly render on github.",
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

The code-element works too, but it does not correctly render on github.

![Build status](https://travis-ci.org/timo-schmid/mdtags.svg?branch=master)
```

## TODO

* Emphasis
* Lists
* ~~Links~~
* Images
* Tables
* Horizontal Rule
* Line Breaks
* Youtube videos
* Create an SBT-Plugin to generate docs

## Build status

![Build status](https://travis-ci.org/timo-schmid/mdtags.svg?branch=master)

![Test coverage](https://coveralls.io/repos/timo-schmid/mdtags/badge.svg?branch=master&service=github)