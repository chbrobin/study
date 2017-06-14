package pers.chbrobin.study.thread.sync;

/**
 * Created by Administrator on 2017/6/14 0014.
 */
public class ThreadA extends Thread {
    private volatile boolean ok;
    private volatile int a;

    public ThreadA(boolean ok, int a) {
        this.ok = ok;
        this.a = a;
    }

    @Override
    public void run() {
        a = 1;
        ok = true;

        System.out.println("threadA a " + a + " ok " + ok);
    }

    public static void main(String[] args) {
        Integer a = 11;
        test(a);
        System.out.println(a);
    }
    public static void test(Integer a) {
        Integer b = a;
        b = b + 1;
        System.out.println(a + " VS " + b);
    }
}
