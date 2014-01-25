name := "A Project"

version := "0.0.1" //List(major, minor, build).mkString(".")

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
)

scalacOptions ++= Seq("-optimise", "-feature", "-deprecation")

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

val major = 0

val minor = 5

lazy val build = doBuild

lazy val doBuild: Int = {
	val file: File = new java.io.File("./buildInfo.properties")
    val prop = new java.util.Properties
    def readProp: Int = {  
      prop.load(new java.io.FileInputStream(file))
      prop.getProperty("buildnumber", "0").toInt
    }
    def writeProp(value: Int) = {
      prop.setProperty("buildnumber", value.toString)
      prop.store(new java.io.FileOutputStream(file), null)
    }
    val current = {
    	if (file.exists) readProp
        else 0
    }        
    writeProp(current + 1)
    current	
}

