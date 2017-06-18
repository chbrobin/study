package pers.chbrobin.study.thread.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/6/13 0013.
 */
public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService executorServiceFixed = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i ++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    System.out.println("executorServiceFixed threadName "  + Thread.currentThread().getName());
                }
            };
            executorServiceFixed.execute(runnable);
        }

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i ++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    System.out.println("executorServiceFixed threadName "  + Thread.currentThread().getName());
                }
            };
            newCachedThreadPool.execute(runnable);
        }

        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 10; i ++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    System.out.println("newSingleThreadExecutor threadName "  + Thread.currentThread().getName());
                }
            };
            newSingleThreadExecutor.execute(runnable);
        }
    }
}
