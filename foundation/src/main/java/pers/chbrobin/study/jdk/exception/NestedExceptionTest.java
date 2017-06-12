package pers.chbrobin.study.jdk.exception;

import java.io.IOException;

/**
 * Created by Administrator on 2017/6/3 0003.
 * 用链式异常来保存原始异常信息
 * Throwable提供四种构造方法，其中有可实现链式异常
 * 不要在finally块中抛出异常，JVM先执行finally块，然后再时行异常处理
 * 如果finally中有异常抛出，就会将原先异常掩没，这个与JVM操作机制有关 先处理finally逻辑再处理异常逻辑
 */
public class NestedExceptionTest extends Exception {
    public NestedExceptionTest(){
        super();
    }

    public NestedExceptionTest(String arg0) {
        super(arg0);
    }

    public NestedExceptionTest(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public NestedExceptionTest(Throwable arg0) {
        super(arg0);
    }


    private static void throwOldException() throws IOException {
        throw new IOException("a forced Exception");
    }

    private static void throwNestedException() throws NestedExceptionTest {
        try {
            throwOldException();
        } catch (IOException e) {
            throw new NestedExceptionTest(e);
        }
    }
    public static void main(String[] args) {
        try {
            throwNestedException(); // 会同时抛出IOException和NestedExceptionTest
        } catch (NestedExceptionTest e) {
            e.printStackTrace();
        }
    }
}
