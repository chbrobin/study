package pers.chbrobin.study.jdk.object;

/**
 * Created by chenhuibin on 2017/7/11 0011.
 * Object toString 默认返回 对象名@地址(16进制)
 */
public class ToStringTest {
    public static void main(String[] args) {
        ToStringTest toStringTest = new ToStringTest();
        System.out.println(toStringTest.toString());
    }
}
