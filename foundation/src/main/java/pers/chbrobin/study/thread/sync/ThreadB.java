package pers.chbrobin.study.thread.sync;

/**
 * Created by Administrator on 2017/6/14 0014.
 */
public class ThreadB extends Thread {
    private volatile boolean ok;
    private volatile int a;

    public ThreadB(boolean ok, int a) {
        this.ok = ok;
        this.a = a;
    }

    @Override
    public void run() {
        System.out.println("threadB a " + a + " ok " + ok);
        while (ok) {
            // 输出的number的值不一定是1
            System.out.println("aaa" + a);
        }
    }
}
