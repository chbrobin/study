package pers.chbrobin.study.jdk.concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by chenhuibin on 2017/6/25 0025.
 * 需要所有的子任务都完成时，才执行主任务，这个时候就可以选择使用CyclicBarrier
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(new Thread(new CyclicBarrierRunner(cyclicBarrier, "CyclicBarrierRunner 1")));
        executor.execute(new Thread(new CyclicBarrierRunner(cyclicBarrier, "CyclicBarrierRunner 2")));
        executor.execute(new Thread(new CyclicBarrierRunner(cyclicBarrier, "CyclicBarrierRunner 3")));
        executor.execute(new Thread(new CyclicBarrierRunner(cyclicBarrier, "CyclicBarrierRunner 4")));
        executor.shutdown();
    }
}

class CyclicBarrierRunner implements Runnable {
    // 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)
    private CyclicBarrier cyclicBarrier;
    private String name;

    public CyclicBarrierRunner(CyclicBarrier cyclicBarrier, String name) {
        super();
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(3) * 1000);
            System.out.println("CyclicBarrierRunner prepare ok");
            // barrier的await方法，在所有参与者都已经在此 barrier 上调用 await 方法之前，将一直等待。
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + " running");
    }
}
