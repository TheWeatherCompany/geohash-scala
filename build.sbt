name := "geohash-scala"
organization := "com.github.davidallsopp"
version := "0.7.0-RELEASE"
scalaVersion := "2.11.8"

resolvers ++= Seq(
  "Artifactory" at "https://repo.artifacts.weather.com/analytics-virtual",
  Resolver.mavenLocal
)

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.11.4" % "test"
)

credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

publishTo <<= version { (v: String) =>
  val base = "https://repo.artifacts.weather.com/analytics-local"
  val repo = if (v.trim.endsWith("SNAPSHOT")) s"$base;build.timestamp=${new java.util.Date().getTime}" else base
  Some("Artifactory Realm" at repo)
}