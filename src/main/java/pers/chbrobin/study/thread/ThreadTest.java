package pers.chbrobin.study.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/6/1 0001.
 * main 为主线程，程序入口
 */
public class ThreadTest {
    public static void main(String[] args) throws Exception {
        System.out.println("current thread " + Thread.currentThread());
        final List<Long> idList = new ArrayList<Long>();
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("current thread " + Thread.currentThread());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                idList.add(1L);
                System.out.println("Runnable");
            }
        };

        MyThread myThread = new MyThread();

        MyCallable myCallable = new MyCallable();
        ExecutorService service = Executors.newCachedThreadPool();
        myThread.setDaemon(true);
        service.submit(runnable);
        service.submit(myThread);
        service.submit(myCallable);

    }
}
