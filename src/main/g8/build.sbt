enablePlugins(ScalaJSBundlerPlugin)

name := "$name$"

scalaVersion := "3.6.3"

Compile / npmDependencies += "react" -> "18.0.0"
Compile / npmDependencies += "react-dom" -> "18.0.0"
Compile / npmDependencies += "react-proxy" -> "1.1.8"

Compile / npmDevDependencies += "file-loader" -> "6.2.0"
Compile / npmDevDependencies += "style-loader" -> "4.0.0"
Compile / npmDevDependencies += "css-loader" -> "7.1.2"
Compile / npmDevDependencies += "html-webpack-plugin" -> "5.6.3"
Compile / npmDevDependencies += "copy-webpack-plugin" -> "6.3.1"
Compile / npmDevDependencies += "webpack-merge" -> "6.0.1"

libraryDependencies += "me.shadaj" %%% "slinky-web" % "0.7.4"
libraryDependencies += "me.shadaj" %%% "slinky-hot" % "0.7.4"

libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.9" % Test

scalacOptions += "-Ymacro-annotations"

webpack / version := "5.97.1"
webpackCliVersion := "6.0.0"
startWebpackDevServer / version := "5.2.0"

webpackResources := baseDirectory.value / "webpack" * "*"

fastOptJS / webpackConfigFile := Some(baseDirectory.value / "webpack" / "webpack-fastopt.config.js")
fullOptJS / webpackConfigFile := Some(baseDirectory.value / "webpack" / "webpack-opt.config.js")
Test / webpackConfigFile := Some(baseDirectory.value / "webpack" / "webpack-core.config.js")

fastOptJS / webpackDevServerExtraArgs := Seq("--hot")
fastOptJS / webpackBundlingMode := BundlingMode.LibraryOnly()

Test / requireJsDomEnv := true

scalaJSUseMainModuleInitializer := true

addCommandAlias("dev", ";fastOptJS::startWebpackDevServer;~fastOptJS")

addCommandAlias("build", "fullOptJS::webpack")

