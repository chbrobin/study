package pers.chbrobin.study.scala

import org.apache.spark.{SparkContext, SparkConf}


/**
  * Created by chenhuibin on 2017/9/26 0026.
  */

/**
  * Created by Administrator on 2017-01-04.
  */
object SparkDemo {
  def main(args: Array[String]): Unit = {
    println(123)
    val conf = new SparkConf().setMaster("spark://centos-vm0:7077").setAppName("firstapp")
    val sc = new SparkContext(conf)
    val a = sc.parallelize(List(1, 2, 3, 4))
    a.persist();
    println(a.count())
    println("============================")
    a.collect().foreach(println)
  }
}