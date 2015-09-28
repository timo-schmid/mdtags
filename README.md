# mdtags - Typesafe MarkDown in Scala

## What is mdtags?

The idea for mdtags is stolen from scala-js: It enables you to
write Markdown in a typesafe manner in scala.

Here's an example:

```markdown
MarkDown(
 h1("Hello from mdtags!"),
 "Make sure to always code typesafe!"
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
* Complete type safety - MarkDown(Any*) won't do.