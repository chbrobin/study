package pers.chbrobin.study.jdk;

/**
 * Created by Administrator on 2017/6/1 0001.
 * assertion���ͨ���ڿ����Ͳ���ʱ������Ϊ��������ܣ������������assertion���ͨ���ǹرյ�
 * assert expression1;
 2.assert expression1: expression2;
 * vm����������� -ea
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
