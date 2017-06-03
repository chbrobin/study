package pers.chbrobin.study.jdk.exception;

/**
 * Created by Administrator on 2017/6/3 0003.
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


}
