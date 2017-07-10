package pers.chbrobin.study.jvm.gc;

/**
 * Created by chenhuibin on 2017/6/24 0024.
 * JVM_OPTIONS: -verbose:gc
 */
public class ReferCountingGcTest {
    public Object instance = null;
    public static void main(String[] args) {
        ReferCountingGcTest a = new ReferCountingGcTest();
        ReferCountingGcTest b = new ReferCountingGcTest();
        a.instance = b;
        b.instance = a;
        System.gc();
    }
}
