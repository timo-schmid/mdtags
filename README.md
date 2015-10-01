# mdtags - Typesafe MarkDown in Scala

## What is mdtags?

The idea for mdtags is stolen from scala-js: It enables you to
write Markdown in a typesafe manner in scala.

Here's an example:

```scala
MarkDown(
  h1("Hello from mdtags!"),
  "Make sure to always code typesafe!",
  """Feel free to add multi-line strings
    |Like this one, for example!""".stripMargin,
  code(
    syntax = "scala",
    code = "List(1,2,3).reverse"
  ),
  code(
    syntax = "scala",
    code = """List("foo", "bar", "baz")
             |  .reverse
             |  .mkString(" - ")""".stripMargin
  )
)
```

## TODO

* Emphasis
* Lists
* Links
* Images
* Tables
* Horizontal Rule
* Line Breaks
* Youtube videos
* ~~Complete type safety - MarkDown(Any*) won't do~~
* Create an SBT-Plugin to generate docs