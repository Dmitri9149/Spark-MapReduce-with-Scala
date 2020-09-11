/* InScala */

import org.apache.spark.sql.SparkSession

object InScala {

    def main(args: Array[String]) {
      
        val logFile = "Alice.txt"
        val spark = SparkSession.builder
          .appName("InScala")
          .getOrCreate()

        spark.sparkContext.setLogLevel("WARN")  

        val logData = spark.read.textFile(logFile).cache()
        val numAlice = logData.filter(line => line.contains("Alice")).count()
        val numRabbit = logData.filter(line => line.contains("Rabbit")).count()
        println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
        println(s"Lines with Alice: $numAlice, Lines with Rabbit: $numRabbit")
        spark.stop()


    }  

}
