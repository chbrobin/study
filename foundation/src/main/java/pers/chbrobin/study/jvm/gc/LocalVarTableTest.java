package pers.chbrobin.study.jvm.gc;

/**
 * Created by chenhuibin on 2017/7/10 0010.
 * JVM_OPTIONS: -verbose:gc
 */
public class LocalVarTableTest {
    public static void main(String[] args) {
        byte[] placeHolder = new byte[64 * 1024 * 1024];
        System.gc();
    }
}
