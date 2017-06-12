package pers.chbrobin.study.jdk;

/**
 * Created by Administrator on 2017/6/4 0004.
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
