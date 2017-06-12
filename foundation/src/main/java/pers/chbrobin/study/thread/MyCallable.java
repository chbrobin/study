package pers.chbrobin.study.thread;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/6/1 0001.
 */
public class MyCallable implements Callable<String> {
    public String call() throws Exception {
        System.out.println("MyCallable");
        return "OK";
    }
}
