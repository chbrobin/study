package pers.chbrobin.study.thread;

/**
 * Created by Administrator on 2017/6/1 0001.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread");
    }

    @Override
    public String toString() {
        return "MyThread toString";
    }
}
