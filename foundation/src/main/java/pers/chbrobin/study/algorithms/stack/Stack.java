package pers.chbrobin.study.algorithms.stack;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
public class Stack {
    private Object[] objs;
    private int index;

    private Stack() {
    }

    public Stack(int size) {
        objs = new Object[size];
        index = -1;
    }

    public void push(Object t) {
        index = index + 1;
        if(index > objs.length - 1) {
            throw new StackIndexOutOfBoundsException();
        }
        objs[index] = t;
    }

    public void pop() {
        if(index == -1) {
            throw new StackIndexOutOfBoundsException();
        }
        objs[index] = null;
        index = index - 1;
    }

    public int size() {
        return index + 1;
    }

    public boolean isEmpty() {
        return index < 0;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(Object obj : objs) {
            if(obj != null) {
                if(!sb.toString().equals("")) {
                    sb.append(",");
                }
                sb.append(obj.toString());
            }
        }
        return sb.toString();
    }
}