package pers.chbrobin.study.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2017/6/1 0001.
 */
public class MyCallable implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(5000);
        return "MyCallable " + Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        List<FutureTask<String>> futureTaskList = new ArrayList<FutureTask<String>>();
        for(int i = 0; i < 10; i++) {
            MyCallable callable = new MyCallable();
            FutureTask<String> futureTask = new FutureTask<String>(callable);
            futureTaskList.add(futureTask);
            Thread thread = new Thread(futureTask);
            thread.start();
        }

        List<String> resultList = new ArrayList<String>();
        try {
            for(FutureTask<String> futureTask : futureTaskList) {
                String string = futureTask.get();
                resultList.add(string);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("resultList " + resultList);
    }
}
