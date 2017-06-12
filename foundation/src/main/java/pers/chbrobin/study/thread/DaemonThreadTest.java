package pers.chbrobin.study.thread;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class DaemonThreadTest implements Runnable {
    public void run() {
        System.out.println("DaemonThreadTest run");
    }

    public static void main(String[] args) {
        DaemonThreadTest daemonThreadTest = new DaemonThreadTest();
        Thread threadTest = new Thread(daemonThreadTest);
        threadTest.start();
    }
}
