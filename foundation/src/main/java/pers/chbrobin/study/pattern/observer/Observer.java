package pers.chbrobin.study.pattern.observer;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class Observer {
    private String name;

    public void update(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {

            public void run() {
            }
        });
    }
}