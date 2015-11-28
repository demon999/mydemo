package com.snow.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 11/28/2015
 * @description
 */
public class Sample1 {
    public static void main(String[] args) {
        test("test","spark://localhost:8080");
    }

    public static void test(String appName,String master) {
        SparkConf conf = new SparkConf().setAppName(appName).setMaster(master);
        JavaSparkContext sc = new JavaSparkContext(conf);

        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        JavaRDD<Integer> distData = sc.parallelize(data);
    }
}
