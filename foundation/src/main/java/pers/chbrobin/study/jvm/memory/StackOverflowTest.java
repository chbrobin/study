package pers.chbrobin.study.jvm.memory;

/**
 * Created by chenhuibin on 2017/6/24 0024.
 * JVM OPTIONS:-Xss128k
 */
public class StackOverflowTest {
    private long stackLeakLength = 0L;
    public void stackLeak() {
        stackLeakLength ++;
        stackLeak();
    }
    public static void main(String[] args) {
        StackOverflowTest stackOverflowTest = new StackOverflowTest();
        try {
            stackOverflowTest.stackLeak();
        } catch (Throwable e) {
            System.out.println("stackLeakLength " + stackOverflowTest.stackLeakLength);
//            e.printStackTrace();
        }
    }
}
