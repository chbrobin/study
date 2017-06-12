package pers.chbrobin.study.jdk;

/**
 * Created by Administrator on 2017/6/1 0001.
 * assertion检查通常在开发和测试时开启。为了提高性能，在软件发布后，assertion检查通常是关闭的
 * assert expression1;
 2.assert expression1: expression2;
 * vm开启加入参数 -ea
 */
public class AssertTest {

    public static void main(String[] args) {

        test1(-1);
        test2(-1);
    }

    private static void test1(int a){
        assert a > 0;
        System.out.println(a);
    }
    private static void test2(int a){
        assert a > 0 : "something goes wrong here, a cannot be less than 0";
        System.out.println(a);
    }
}