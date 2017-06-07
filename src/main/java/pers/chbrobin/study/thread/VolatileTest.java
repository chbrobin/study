package pers.chbrobin.study.thread;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class VolatileTest {
    private static volatile long i = 0;
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                i = new Date().getTime();
                System.out.println("thread1 "  + i);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                i = new Date().getTime();
                System.out.println("thread2 "  + i);
            }
        });

        thread1.start();
        thread2.start();
    }
}
