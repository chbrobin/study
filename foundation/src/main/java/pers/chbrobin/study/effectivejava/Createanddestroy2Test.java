package pers.chbrobin.study.effectivejava;

/**
 * Created by chenhuibin on 2017/7/15 0015.
 * 第2条：使用私有构造函数强化Singleton悟性
 *
 * 使用枚举方法构建单例方法
 */
public class Createanddestroy2Test {

    public static void main(String[] args) {
        EnumTest enumTest = EnumTest.ENUM_TEST;
        System.out.println(enumTest);
    }

    public static enum EnumTest {
        ENUM_TEST;
    }
}
