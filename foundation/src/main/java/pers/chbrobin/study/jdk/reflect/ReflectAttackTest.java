package pers.chbrobin.study.jdk.reflect;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Created by chenhuibin on 2017/7/1 0001.
 * 反射攻击
 */
public class ReflectAttackTest {
    public static void attack() throws Exception {
        Class<?> classType = Singleton.class;
        Constructor<?> constructor = classType.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        Singleton singleton2 = Singleton.newInstance();
        System.out.println(singleton2);
//        Singleton singleton = (Singleton) constructor.newInstance();
        //System.out.println(singleton == singleton2);

        Unsafe unsafe = getUnsafeInstance();
        Singleton ut = (Singleton)unsafe.allocateInstance(Singleton.class);
        System.out.println(ut);
    }
    public static void main(String[] args) {
        try {
            attack();

            SingletonEnum singletonEnum = SingletonEnum.Instance;
            System.out.println(singletonEnum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Unsafe getUnsafeInstance() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }

}
