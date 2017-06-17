package pers.chbrobin.study.algorithms.stack;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack(2);
        System.out.println("stack isEmpty " + stack.isEmpty());
        stack.push(new Integer(1));
        stack.push(new Integer(2));
        stack.pop();
        stack.push(new Integer(3));
        stack.pop();
        System.out.println("stack toString " + stack.toString());
        System.out.println("stack size " + stack.size());
    }
}
