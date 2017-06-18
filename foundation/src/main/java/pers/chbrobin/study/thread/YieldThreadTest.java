package pers.chbrobin.study.thread;

/**
 * Created by Administrator on 2017/6/18 0018.
 */
public class YieldThreadTest {

    public static void main(String[] args) {
        for(int i = 0; i < 20; i ++) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + " index " + i);
                    }
                }
            });
            t.start();
            t.yield();
        }
    }
}

class YieldTest extends Thread {
    @Override
    public void run() {
        super.run();
    }
}

