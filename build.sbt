import bintray._
import sbt.Keys._
import sbt._

name := "mdtags"

organization := "io.mdtags"

scalaVersion := "2.10.5"

version := "0.1-SNAPSHOT"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

publishMavenStyle := false

bintrayPublishSettings

bintray.Keys.repository in bintray.Keys.bintray := "maven"

bintray.Keys.bintrayOrganization in bintray.Keys.bintray := None

// undecided
licenses += ("Apache 2.0", url("http://opensource.org/licenses/Apache-2.0"))

lazy val compileScalastyle = taskKey[Unit]("testScalastyle")

compileScalastyle := org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Compile).toTask("").value

(compile in Compile) <<= (compile in Compile) dependsOn compileScalastyle

