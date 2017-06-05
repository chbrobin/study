package pers.chbrobin.study.thread;

/**
 * Created by Administrator on 2017/6/5 0005.
 */
public class SynchronizedTest {

    private class Thread1 extends Thread {
        Object lock = new Object();

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("lock");
            }
        }
    }

    private class Thread2 extends Thread {
        @Override
        public synchronized void run() {
            System.out.println("lock");
        }
    }

    public Thread1 genThread1() {
        return new Thread1();
    }

    public Thread2 genThread2() {
        return new Thread2();
    }

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        Thread1 thread1 = synchronizedTest.genThread1();
        Thread2 thread2 = synchronizedTest.genThread2();
        thread1.start();
        thread2.start();
    }
}
