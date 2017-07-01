package pers.chbrobin.study.thread;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/6/29 0029.
 */
public class DemoTest {
    public static List<Integer> numberList = new Vector<Integer>();

    public static void main(String[] args) {
        Integer i = 0;
        for(int k = 0; k < 100; k++){
            i ++;
            System.out.println(i);
        }
    }
}
