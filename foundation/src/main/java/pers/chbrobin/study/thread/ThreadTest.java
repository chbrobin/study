package pers.chbrobin.study.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/6/1 0001.
 * main 为主线程，程序入口
 * main's parent is system
 * thread main group name is main
 *
 * 线程组是为了方便线程的管理 可以统一设定线程组的一些属性，比如setDaemon，设置未处理异常的处理方法，设置统一的安全策略等等；
 * 也可以通过线程组方便的获得线程的一些信息
 * 每一个ThreadGroup都可以包含一组的子线程和一组子线程组，在一个进程中线程组是以树形的方式存在，
 * 通常情况下根线程组是system线程组。system线程组下是main线程组，默认情况下第一级应用自己的线程组是通过main线程组创建出来的。
 *
 * 线程池是为了管理线程的生命周期，复用线程，减少创建销毁线程的开销
 */
public class ThreadTest {
    public static void main(String[] args) throws Exception {
        ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");
        System.out.println("myThreadGroup parent " + threadGroup.getParent().getName()); // 为main
        System.out.println("current thread threadGroup " + Thread.currentThread().getThreadGroup());
        System.out.println("current thread " + Thread.currentThread());
        final List<Long> idList = new ArrayList<Long>();
        Runnable runnable = new Runnable() {
            public void run() {
                Thread.currentThread().yield();
                System.out.println("current thread A " + Thread.currentThread());
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
