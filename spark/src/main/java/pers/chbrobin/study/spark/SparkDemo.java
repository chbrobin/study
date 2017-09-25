package pers.chbrobin.study.spark;

import org.apache.commons.io.FileUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by chenhuibin on 2017/9/25 0025.
 * bin/spark-submit --class pers.chbrobin.study.spark.SparkDemo --master spark://centos-vm0:7077 ../mylib/spark-1.0-SNAPSHOT.jar /in/test.log /out/output1
 */
public class SparkDemo {
    private static JavaSparkContext javaSparkContext = null;

    public static void init(String appName, String master) {
        SparkConf conf = new SparkConf().setAppName(appName).setMaster(master);
        javaSparkContext = new JavaSparkContext(conf);
    }

    @SuppressWarnings("serial")
    private static void wordCount(String filePath, String fileDir) {
        FileUtils.deleteQuietly(new File(fileDir));

        JavaRDD<String> file = javaSparkContext.textFile(filePath);

        JavaRDD<String> words = file.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return  Arrays.asList(s.split(" ")).iterator();
            }
        });

        JavaPairRDD<String, Integer> pairs = words.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) {
                return new Tuple2<String, Integer>(s, 1);
            }
        });

        JavaPairRDD<String, Integer> counts = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer a, Integer b) {
                return a + b;
            }
        });

        counts.saveAsTextFile(fileDir);
    }

    @SuppressWarnings("serial")
    private static void errorCount(String filePath) {
        JavaRDD<String> file = javaSparkContext.textFile(filePath);

        JavaRDD<String> errors = file.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.contains("ERROR");
            }
        });

        errors.count();

        errors.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.contains("ORACLE");
            }
        }).count();

        errors.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.contains("ORACLE");
            }
        }).collect();
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Please provide the input file full path and output dir as argument");
            System.exit(0);
        }

        SparkDemo.init("pers.chbrobin.study.spark", "spark://centos-vm0:7077");

        SparkDemo.wordCount(args[0], args[1]);

        SparkDemo.errorCount(args[0]);
    }
}
