package pers.chbrobin.study.algorithms.queue;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println("queue " + queue.toString());
        System.out.println(queue.pop());
        System.out.println("queue " + queue.toString());
        System.out.println(queue.pop());
        System.out.println("queue " + queue.toString());
        System.out.println(queue.pop());
        System.out.println("queue " + queue.toString());
        queue.push(5);
        System.out.println("queue " + queue.toString());
        System.out.println(queue.pop());
        System.out.println("queue " + queue.toString());
        queue.push(5);
        System.out.println("queue " + queue.toString());
        System.out.println(queue.pop());
        System.out.println("queue " + queue.toString());
        System.out.println(queue.pop());
        System.out.println("queue " + queue.toString());
    }
}
