package pers.chbrobin.study.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhuibin on 2017/6/24 0024.
 * JVM OPTIONS: -XX:PermSize=10m -XX:MaxPermSize=10m
 * HotSpot已将运行时常量池并入堆中
 */
public class RuntimeConstantPoolOutOfMemoryTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
            System.out.println("test" + i);
        }
    }
}
