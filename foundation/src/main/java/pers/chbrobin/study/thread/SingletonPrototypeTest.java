package pers.chbrobin.study.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/5 0005.
 */
public class SingletonPrototypeTest {
    private class Util {
        public void print(String name) {
            System.out.println("print thread " + name);
        }
        public Util2 getUtil2() {
            return new Util2();
        }
    }

    private class Util2 {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public void print() {
            System.out.println("print thread " + name);
        }
    }

    private Util getUtil() {
        return new Util();
    }

    public static void main(String[] args) {
        SingletonPrototypeTest test = new SingletonPrototypeTest();

        final Util util = test.getUtil();

        List<Thread> threadList = new ArrayList<Thread>();
        for(int i = 0; i < 100000; i ++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    // 无状态单例
                    util.print(Thread.currentThread().getName());

                    // 多状态多态
                    Util2 util2 = util.getUtil2();
                    util2.setName(Thread.currentThread().getName());
                    util2.print();
                }
            }, "newThread" + i);
            threadList.add(thread);
        }

        for(Thread thread : threadList) {
                thread.start();
        }
    }
}
