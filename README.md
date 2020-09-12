### Spark application with Scala 

#### Some simple transformations and actions

The 'Aice's Adventures in Wonderland by Lewis 
Carroll' book from Gutenberg project 
https://www.gutenberg.org/ebooks/11 is used for the analysis. 

console output

```
dmitri@dmitri-Lenovo-H50-00:~/spark/self_contained/Scala$ /opt/spark/bin/spark-submit   --class "InScala"   --master local[4]  target/scala-2.12/simple-project_2.12-1.0.jar
.......................................

*****************************************************************

Number of lines: 3773

First line:   The Project Gutenberg EBook of Alice’s Adventures in Wonderland, by Lewis Carroll

How many lines contains 'Alice':  399

Max number of words in one line is:  37

Lines with 'Alice': 399, Lines with 'Rabbit': 47

The 20 'words' in the Dataset: 

(online,4)
(flashed,1)
(some,47)
(still,12)
(hope,4)
(high:,3)
(those,9)
(few,10)
(way!,1)
(waters,1)
(hippopotamus,,1)
(mouse:,1)
(knot!”,1)
(By,4)
(hoped),1)
(enough;,2)
(_what_,1)
(youth,,3)
(replied;,3)
(eggs,,3)
*****************************************************************
```
