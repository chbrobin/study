package pers.chbrobin.study.jdk;

/**
 * Created by Administrator on 2017/6/14 0014.
 */
public class ImmutableTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println("s1 == s2 " + (s1 == s2));
        System.out.println("s1 == s3 " + (s1 == s3));

        Integer t1 = 1;
        Integer t2 = 1;
        Integer t3 = new Integer(1);
        System.out.println("t1 == t2 " + (t1 == t2));
        System.out.println("t1 == t3 " + (t1 == t3));

        testString(new String("str"));
        testInteger(new Integer(1));
    }

    public static void testString(String str) {
        String str1 = str;
        str1 = "str1";
        System.out.println("str " + str  + " str1 " + str1);
    }

    public static void testInteger(Integer intObj) {
        Integer int1 = intObj;
        int1 = int1 + 2;
        System.out.println("intObj " + intObj  + " int1 " + int1);
    }
}