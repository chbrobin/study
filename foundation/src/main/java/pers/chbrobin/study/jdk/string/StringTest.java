package pers.chbrobin.study.jdk.string;

/**
 * Created by Administrator on 2017/6/4 0004.
 * CharSequence就是字符序列，String, StringBuilder和StringBuffer本质上都是通过字符数组实现的！
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "aa" + "bb";
        String s2 = "aabb";
        String s3 = new String("aabb");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
