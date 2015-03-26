name := """arquisoft-app"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaJpa,
  javaWs,
  "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
  "org.postgresql" % "postgresql" % "9.2-1003-jdbc4",
  "org.webjars" % "bootstrap" % "3.0.2"
)
