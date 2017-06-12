package pers.chbrobin.study.thread;

/**
 * Created by Administrator on 2017/6/6 0006.
 * 任何一个守护线程都是整个JVM中所有非守护线程的保姆
 * 只要当前JVM实例中尚存在任何一个非守护线程没有结束，守护线程就全部工作；
 * 只有当最后一个非守护线程结束时，守护线程随着JVM一同结束工作
 * Daemon的作用是为其他线程的运行提供便利服务，守护线程最典型的应用就是 GC (垃圾回收器)，
 * 它就是一个很称职的守护者
 *
 * 1) thread.setDaemon(true)必须在thread.start()之前设置，否则会跑出一个IllegalThreadStateException异常。你不能把正在运行的常规线程设置为守护线程
 * 2) 在Daemon线程中产生的新线程也是Daemon的。
 * 3) 不是所有的应用都可以分配给Daemon线程来进行服务，比如读写操作或者计算逻辑。因为在Daemon Thread还没来的及进行操作时，虚拟机可能已经退出了
 *
 * 应用场景
 * web服务器中的Servlet，容器启动时后台初始化一个服务线程，即调度线程，负责处理http请求，
 * 然后每个请求过来调度线程从线程池中取出一个工作者线程来处理该请求，从而实现并发控制的目的
 *
 * 定义：守护线程--也称“服务线程”，在没有用户线程可服务时会自动离开
 * 优先级：守护线程的优先级比较低，用于为系统中的其它对象和线程提供服务
 *
 */
public class DaemonThreadTest implements Runnable {
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("DaemonThreadTest run");
    }

    public static void main(String[] args) {
        DaemonThreadTest daemonThreadTest = new DaemonThreadTest();
        Thread threadTest = new Thread(daemonThreadTest);
        threadTest.setDaemon(true);// if true can not print DaemonThreadTest run
        threadTest.start();
        // 主线程结束了，守护线程没有可以守护的线程，自然也会结束，并不会执行run()方法
    }
}
