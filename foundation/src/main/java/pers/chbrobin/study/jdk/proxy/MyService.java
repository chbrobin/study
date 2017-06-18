package pers.chbrobin.study.jdk.proxy;

/**
 * Created by Administrator on 2017/6/17 0017.
 */
public class MyService implements Service {
    public void add() {
        System.out.println("MyService add");
    }

    public void update() {
        System.out.println("MyService update");
    }
}
