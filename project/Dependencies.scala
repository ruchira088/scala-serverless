import sbt._

object Dependencies {

  val SCALA_VERSION = "2.12.8"

  lazy val awsLambdaJavaEvents = "com.amazonaws" % "aws-lambda-java-events" % "2.2.5"

  lazy val awsLambdaJavaCore = "com.amazonaws" % "aws-lambda-java-core" % "1.2.0"

  lazy val playJson = "com.typesafe.play" %% "play-json" % "2.7.1"
}
