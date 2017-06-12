/**
 * Created by Administrator on 2017/6/10 0010.
 * 按线程多实例（每个线程对应一个实例）的对象的访问，并且这个对象很多地方都要用到。
 */
public class ThreadLocalTest {
    private volatile String aa = "";

    class MyThreadLocal extends Thread {
        MyService myService;

        public MyThreadLocal(MyService myService) {
            this.myService = myService;
        }
        @Override
        public void run() {
            System.out.println(myService.getString());
        }
    }

    class MyService {
        ThreadLocal<String> threadLocal = new ThreadLocal<String>();

        public String getString() {
            String str = threadLocal.get();
            if(str == null) {
                threadLocal.set("aaa" + Thread.currentThread().getName());
            }
            return threadLocal.get();
        }
    }

    public static void main(String[] args) {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        for(int i = 0; i < 10; i ++) {
            MyThreadLocal myThreadLocal = threadLocalTest.new MyThreadLocal(threadLocalTest.new MyService());
            myThreadLocal.start();
        }
    }
}
