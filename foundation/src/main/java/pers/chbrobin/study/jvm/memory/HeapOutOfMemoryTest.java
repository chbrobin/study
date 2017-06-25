package pers.chbrobin.study.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhuibin on 2017/6/24 0024.
 * VM OPTIONS:-Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 * 对象不对有效地GC
 */
public class HeapOutOfMemoryTest {
    private String testString = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    public static void main(String[] args) {
        List<HeapOutOfMemoryTest> list = new ArrayList<>();
        while (true) {
            HeapOutOfMemoryTest heapOutOfMemoryTest = new HeapOutOfMemoryTest();
            list.add(heapOutOfMemoryTest);
            System.out.println("test" + list.size());
        }
    }
}
