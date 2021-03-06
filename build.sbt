import Dependencies._

import scala.language.postfixOps
import sys.process._

lazy val root =
  (project in file("."))
      .enablePlugins(BuildInfoPlugin)
      .settings(
        name := "scala-serverless",
        organization := "com.ruchij",
        version := "0.0.2",
        scalaVersion := SCALA_VERSION,
        assemblyJarName in assembly := "scala-serverless.jar",
        buildInfoKeys := BuildInfoKey.ofN(name, organization, version, scalaVersion, sbtVersion),
        buildInfoPackage := "com.ruchij.eed3si9n",
        libraryDependencies ++=
          Seq(
            awsLambdaJavaCore,
            awsLambdaJavaEvents,
            playJson
          )
      )

lazy val serverlessDeploy = taskKey[Unit]("Deploy Serverless service")

serverlessDeploy := {
  "serverless deploy -v" !
}

addCommandAlias("deploy", ";assembly ;serverlessDeploy")