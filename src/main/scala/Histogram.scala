import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object Histogram {

  def main(args: Array[String]) {
    /* ... */
    val conf = new SparkConf().setAppName("Histogram")
    val sc = new SparkContext(conf)

    val lines = sc.textFile(args(0))

    val value = lines.flatMap(line => {
      val split = line.split(",")
      
      Array(((1 + " " + split(0)), 1), ((2 + " " + split(1)), 1), ((3 + " " + split(2)), 1))

    }).reduceByKey(_ + _)
    
    val res = value.map(value=>value._1+" "+value._2)

    res.collect().foreach(println)

    sc.stop()

  }
}
