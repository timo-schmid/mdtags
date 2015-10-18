import bintray._
import sbt.Keys._
import sbt._

name := "mdtags"

organization := "io.mdtags"

scalaVersion := "2.11.7"

version := "1.0-alpha2"

libraryDependencies += "org.specs2" %% "specs2" % "2.4.2" % "test"

publishMavenStyle := false

bintrayRepository := "sbt-plugins"

bintrayOrganization := None

licenses += ("Apache-2.0", url("http://opensource.org/licenses/Apache-2.0"))

lazy val compileScalastyle = taskKey[Unit]("testScalastyle")

compileScalastyle := org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Compile).toTask("").value

(compile in Compile) <<= (compile in Compile) dependsOn compileScalastyle

