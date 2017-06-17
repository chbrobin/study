package pers.chbrobin.study.algorithms.queue;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
public class Queue {
    private Object[] objs;
    private int head;
    private int tail;

    public Queue(int size) {
        objs = new Object[size];
        head = 0;
        tail = 0;
    }

    public void push(Object obj) {
        if(head == objs.length -1) {
            if(objs[0] != null) {
                throw new QueueIndexOutOfBoundsException();
            }
            head = 0;
        } else {
            objs[head] = obj;
            head++;
        }
    }

    public Object pop() {
        Object obj = objs[tail];
        objs[tail] = null;
        if(tail == objs.length -1) {
            if(objs[0] != null) {
                throw new QueueIndexOutOfBoundsException();
            }
            tail = 0;
        } else {
            tail++;
        }
        return obj;
    }

    public boolean isEmpty() {
        return false;
    }

    public String toString() {
        return Arrays.asList(objs).toString();
    }

}
