package pers.chbrobin.study.thread.sync;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/6/14 0014.
 */
public class ThreadTest {
    static AtomicInteger a =  new AtomicInteger(1);
    static Integer b = 1;
    static Integer c = 1;
    public Integer d = 1;
    public Integer e = 1;
    class ThreadA implements Runnable {
        ThreadTest tt;
        Integer ee;
        public ThreadA(ThreadTest tt, Integer ee) {
            this.tt  = tt;
            this.ee = ee;
        }
        public void run() {
            synchronized (ThreadA.class) {
                tt.d = tt.d + 1;
                ee = ee + 1;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        ThreadTest tt = new ThreadTest();

        final Thread [] threads = new Thread[1000];
        final Thread [] threadTas = new Thread[1000];
        for(int i = 0 ; i < 1000 ; i++) {
            final int num = i;
            threads[i] = new Thread() {
                public void run() {
                    c = c + 1;
                    a.incrementAndGet();
                    synchronized (ThreadTest.class) {
                        b = b + 1;
                    }
                }
            };
            threads[i].start();

//            tt.d = tt.d + 10;
            threadTas[i] = new Thread(tt.new ThreadA(tt, tt.e));
            threadTas[i].start();
        }
        for(Thread t : threads) {
            t.join();
        }

        for(Thread t : threadTas) {
            t.join();
        }

        System.out.println("最终运行结果a：" + a);
        System.out.println("最终运行结果b：" + b);
        System.out.println("最终运行结果c：" + c);
        System.out.println("最终运行结果d：" + tt.d);
        System.out.println("最终运行结果d：" + tt.e);
    }
}