package pers.chbrobin.study.thread;

import java.util.Random;

/**
 * Created by Administrator on 2017/6/18 0018.
 * 只有在Synchronized方法或Synchronized代码块中才能使用
 *
 * 和Thread的区别
 * 其实两者都可以让线程暂停一段时间,但是本质的区别是一个线程的运行状态控制,一个是线程之间的
 */
public class WaitThreadTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Thread threadP = new Thread(producer);
        threadP.start();

        Customer customer = new Customer(clerk);
        Thread threadC = new Thread(customer);
        threadC.start();
    }
}

class Clerk {
    private int productNum = 0;
    public Clerk() {

    }
    public synchronized void addProduct() {
        System.out.println("addProduce productNum " + productNum);
        if(productNum > 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            productNum = productNum + 1;
            System.out.println("生产者生产1件");
            notifyAll();// 产品数量没到上线，通知其他线程来进行存或则取
        }
    }

    public synchronized void getProduct() {
        System.out.println("getProduct productNum " + productNum);
        if(productNum < 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            productNum = productNum - 1;
            notifyAll(); // 产品数量没到下线，通知其他线程来进行存或则取
            System.out.println("消费者取走1件");
        }
    }

}

class Producer implements Runnable { // 生产者线程
    private Clerk clerk;
    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }
    public void run() {
        System.out.println("生产者开始生产产品....");
        while (true) {
            try {
                Thread.sleep(new Random().nextInt(3000));
            } catch (Exception e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }

    }
}

class Customer implements Runnable {
    private Clerk clerk;
    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }
    public void run() {
        System.out.println("消费者开始取走产品");
        while (true) {
            try {
                Thread.sleep(new Random().nextInt(3000));
            } catch (Exception e) {
                e.printStackTrace();
            }
            clerk.getProduct();
        }
    }
}
