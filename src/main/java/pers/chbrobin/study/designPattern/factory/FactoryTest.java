package pers.chbrobin.study.designPattern.factory;

/**
 * Created by Administrator on 2017/6/2 0002.
 */
public class FactoryTest {
    public static void main(String[] args) {
        Language l1 = MyFactory.createLanguage("java");
        l1.printHelloWord();
        Language l2 = MyFactory.createLanguage("php");
        l2.printHelloWord();
    }
}
