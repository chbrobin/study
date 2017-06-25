package pers.chbrobin.study.jvm.memory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017/6/24 0024.
 * JVM OPTIONS:-Xmx20m -XX:MaxDirectMemorySize=10m
 * 直接或间接使用了NIO
 */
public class DirectMemoryOutOfMemoryTest {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
