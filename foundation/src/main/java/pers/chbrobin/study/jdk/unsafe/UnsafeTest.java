package pers.chbrobin.study.jdk.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by chenhuibin on 2017/6/26 0026.
 * 这个类是用于执行低级别、不安全操作的方法集合。
 * 尽管这个类和所有的方法都是公开的（public），但是这个类的使用仍然受限，
 * 你无法在自己的java程序中直接使用该类，因为只有授信的代码才能获得该类的实例。
 *
 * 从上面的描述，可以了解到该类是用来执行较低级别的操作的，
 * 比如获取某个属性在内存中的位置，不过一般人很少会有这样的需求。
 */
public class UnsafeTest {
    private String testField;
    public static void main(String[] args) throws Exception {
//        Unsafe unsafe = Unsafe.getUnsafe(); // 安全性检查，无法直接访问
//        unsafe.compareAndSwapObject()

        Unsafe unsafe = getUnsafeInstance();

        System.out.println(unsafe);

//        unsafe.allocateMemory(1111L);
//        unsafe.reallocateMemory(1111L,20000L);
//        unsafe.freeMemory(1111L);

        UnsafeTest unsafeTest = new UnsafeTest();
        Field[] fs = unsafeTest.getClass().getDeclaredFields();
        System.out.println(unsafe.objectFieldOffset(fs[0]));

        UnsafeTest ut = (UnsafeTest)unsafe.allocateInstance(UnsafeTest.class);

        UnsafeObject unsafeObject = new UnsafeObject();
        unsafeObject.setStrObj("aaa");
        unsafeObject.setLongObj(111L);
        unsafeObject.setBooleanObj(true);
        System.out.println(unsafeObject);
        Class unsafeObjectClass = UnsafeObject.class;
        Field strField = unsafeObjectClass.getDeclaredField("strObj");
        Field longField = unsafeObjectClass.getDeclaredField("longObj");
        Field booleanField = unsafeObjectClass.getDeclaredField("booleanObj");
        System.out.println(unsafe.objectFieldOffset(strField));
        System.out.println(unsafe.objectFieldOffset(longField));
        System.out.println(unsafe.objectFieldOffset(booleanField));
        // 根据内在地址写数据
        unsafe.putObject(unsafeObject, unsafe.objectFieldOffset(strField), "bbb");
        unsafe.putObject(unsafeObject, unsafe.objectFieldOffset(longField),222);
        unsafe.putBoolean(unsafeObject, unsafe.objectFieldOffset(booleanField), false);

        unsafe.putObjectVolatile(unsafeObject, unsafe.objectFieldOffset(strField), "CCC");

//        System.out.println(unsafe.getAddress(1));
        System.out.println(unsafeObject);

        //相对时间后面的参数单位是纳秒
        unsafe.park(false, 3000000000l);

        System.out.println("SUCCESS!!!");

    }

    private static Unsafe getUnsafeInstance() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }

    public String getTestField() {
        return testField;
    }

    public void setTestField(String testField) {
        this.testField = testField;
    }
}
