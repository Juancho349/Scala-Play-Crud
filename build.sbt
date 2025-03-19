lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  //.enablePlugins(PlayNettyServer).disablePlugins(PlayPekkoHttpServer) // uncomment to use the Netty backend
  .settings(
    name := """play-scala-starter-example""",
    version := "1.0-SNAPSHOT",
    crossScalaVersions := Seq("2.13.16", "3.3.5"),
    scalaVersion := crossScalaVersions.value.head,
    libraryDependencies ++= Seq(
      guice,
      "com.typesafe.slick" %% "slick" % "3.4.1", // Asegúrate de usar la versión más reciente
      "mysql" % "mysql-connector-java" % "8.0.33", // Asegúrate de usar la versión más reciente
      "com.typesafe.slick" %% "slick-hikaricp" % "3.4.1", // Para el pool de conexiones
      "com.typesafe" % "config" % "1.4.2", // Para leer la configuración
      "com.h2database" % "h2" % "2.3.232",
      "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test,
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-Werror"
    ),
    // Needed for ssl-config to create self signed certificated under Java 17
    Test / javaOptions ++= List("--add-exports=java.base/sun.security.x509=ALL-UNNAMED"),
  )
