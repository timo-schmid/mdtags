import sbt.Keys._
import sbt._

scalaVersion := "2.10.5"

scalacOptions ++= Seq("-feature")

lazy val compileScalastyle = taskKey[Unit]("testScalastyle")

compileScalastyle := org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Compile).toTask("").value

(compile in Compile) <<= (compile in Compile) dependsOn compileScalastyle

lazy val root = (project in file("."))
  .settings(
    name := "mdtags",
    organization := "io.mdtags",
    version := "0.1-SNAPSHOT",
    libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  )
