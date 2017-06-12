package pers.chbrobin.study.thread;

/**
 * Created by Administrator on 2017/6/5 0005.
 * 线程会不时地检测中断标识位，以判断线程是否应该被中断（中断标识值是否为true）。
 * 中断只会影响到wait状态、sleep状态和join状态。被打断的线程会抛出InterruptedException。
 */
public class InterruptedTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("test interrupted");

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
