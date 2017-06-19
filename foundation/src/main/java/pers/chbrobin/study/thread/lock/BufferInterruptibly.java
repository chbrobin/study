package pers.chbrobin.study.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/6/19 0019.
 */
public class BufferInterruptibly {
    ReentrantLock lock = new ReentrantLock();
    public void write() {
        lock.lock();
        try {
            for(int i = 0; i < 100; i++) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void read() throws InterruptedException {
        lock.lockInterruptibly(); // 注意这里，可以响应中断
        try {
            System.out.println("从这个buffer读数据");
        } finally {

        }
    }

}
