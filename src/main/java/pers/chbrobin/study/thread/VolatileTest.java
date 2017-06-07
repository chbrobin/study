package pers.chbrobin.study.thread;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/7 0007.
 * volatile本质是在告诉jvm当前变量在寄存器（工作内存）中的值是不确定的，需要从主存中读取； synchronized则是锁定当前变量，只有当前线程可以访问该变量，其他线程被阻塞住。
 * volatile仅能使用在变量级别；synchronized则可以使用在变量、方法、和类级别的
 * volatile仅能实现变量的修改可见性，不能保证原子性；而synchronized则可以保证变量的修改可见性和原子性
 * volatile不会造成线程的阻塞；synchronized可能会造成线程的阻塞。
 * volatile标记的变量不会被编译器优化；synchronized标记的变量可以被编译器优化
 */
public class VolatileTest {
    private static volatile long i = 0;
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                i = new Date().getTime();
                System.out.println("thread1 "  + i);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                i = new Date().getTime();
                System.out.println("thread2 "  + i);
            }
        });

        thread1.start();
        thread2.start();
    }
}
