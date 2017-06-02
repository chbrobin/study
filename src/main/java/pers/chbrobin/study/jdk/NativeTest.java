package pers.chbrobin.study.jdk;

/**
 * Created by Administrator on 2017/6/2 0002.
 */
public class NativeTest {
    native String nativeTest();

    static {
        System.loadLibrary("NativeTest");
    }

    public static void main(String[] args) {
        NativeTest nativeTest = new NativeTest();
        nativeTest.nativeTest();
    }
}
