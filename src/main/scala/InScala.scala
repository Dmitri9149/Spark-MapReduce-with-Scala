/* InScala */

/* basing on https://spark.apache.org/docs/latest/quick-start.html */

import org.apache.spark.sql.SparkSession
import java.lang.Math

object InScala {

    def main(args: Array[String]) {
      
        val logFile = "Alice.txt"
        val spark = SparkSession.builder
          .appName("InScala")
          .getOrCreate()


        val sqlContext = spark.sqlContext
        import sqlContext.implicits._ //sqlContext OR spark implicits
        //import spark.implicits._ //sqlContext OR spark implicits  

        spark.sparkContext.setLogLevel("WARN")  
        
        val textFile = spark.read.textFile(logFile)
        val logData = spark.read.textFile(logFile).cache()
        val numAlice = logData.filter(line => line.contains("Alice")).count()
        val numRabbit = logData.filter(line => line.contains("Rabbit")).count()
        val numLines = logData.count()
        val firstLine = logData.first()  
        val linesWithAlice = logData.filter(line => line.contains("Alice")).count()
        val withMaxNumber = textFile.map(line => line.split(" ").size)reduce((a,b)=> Math.max(a,b))
        val wordCount = textFile.flatMap(line => line.split(" ")).groupByKey(identity).count()
        val wordCollection = wordCount.collect()


        println("*****************************************************************\n")

        println(s"Number of lines: $numLines\n") 

        println(s"First line:   $firstLine\n")

        println(s"How many lines contains 'Alice':  $linesWithAlice\n")

        println(s"Max number of words in one line is:  $withMaxNumber\n")
      
        println(s"Lines with 'Alice': $numAlice, Lines with 'Rabbit': $numRabbit\n")

        println("The 20 'words' in the Dataset: \n")

        wordCount.take(20).foreach(println)

        println("*****************************************************************\n")

        spark.stop()


    }  

}
