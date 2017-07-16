package pers.chbrobin.study.jdk.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhuibin on 2017/7/16 0016.
 * 多线程基本接口
 */
public class RunnableTest {
    public static void main(String[] args) {
        List<Runnable> runnables = new ArrayList<>();
        runnables.add(new Thread());

        for(Runnable runnable : runnables) {
            System.out.println(runnable.getClass());
        }
    }
}
