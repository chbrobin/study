package pers.chbrobin.study.effectivejava;

/**
 * Created by chenhuibin on 2017/7/15 0015.
 * 第4条：避免创建重复的对象
 *
 * 构造函数在每次被调用的时候都会创建一个新对象，而静态工厂方法从来不要求这样做
 */
public class Createanddestroy4Test {

    public static void main(String[] args) {
        EnumTest enumTest = EnumTest.ENUM_TEST;
        System.out.println(enumTest);
    }

    public static enum EnumTest {
        ENUM_TEST;
    }
}
