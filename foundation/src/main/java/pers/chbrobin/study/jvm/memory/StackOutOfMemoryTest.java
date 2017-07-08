package pers.chbrobin.study.jvm.memory;

/**
 * Created by chenhuibin on 2017/6/24 0024.
 * JVM OPTIONS:-Xss2m
 */
public class StackOutOfMemoryTest {
    public void loop() {
        while (true) {

        }
    }
    public void stackLeakByThread() {
        while(true) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    loop();
                }
            });
            t.start();
        }
    }

    public static void main(String[] args) {
//        StackOutOfMemoryTest stackOutOfMemoryTest = new StackOutOfMemoryTest();
//        stackOutOfMemoryTest.stackLeakByThread();
        long aa[] = new long[100000];
        for(int i = 0; i < 100000; i ++ ) {
            aa[i] = i;
        }
    }
}
