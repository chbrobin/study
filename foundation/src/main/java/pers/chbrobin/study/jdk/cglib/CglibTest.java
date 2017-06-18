package pers.chbrobin.study.jdk.cglib;

/**
 * Created by Administrator on 2017/6/17 0017.
 */
public class CglibTest {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Base base = Factory.getInstance(proxy);
        base.add();
    }
}
