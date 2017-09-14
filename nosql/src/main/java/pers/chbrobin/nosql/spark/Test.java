package pers.chbrobin.nosql.spark;

/**
 * Created by chenhuibin on 2017/8/30 0030.
 */
public class Test {
    public static void main(String[] args) {
        JavaRDD<String> textFile = sc.textFile("hdfs://...");
        JavaPairRDD<String, Integer> counts = textFile
                .flatMap(s -> Arrays.asList(s.split(" ")).iterator())
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a, b) -> a + b);
        counts.saveAsTextFile("hdfs://...");
    }
}
