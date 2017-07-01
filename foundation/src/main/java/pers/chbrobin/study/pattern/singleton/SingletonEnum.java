package pers.chbrobin.study.pattern.singleton;

/**
 * Created by chenhuibin on 2017/6/11 0011.
 * Java SE 5才提供的一种类型
 * final 类型
 * 单例线程安全、防反射攻击、防止序列化生成新的实例
 * 1. 枚举写法简单
 *
 * 2. 枚举自己处理序列化
 * 在序列化的时候Java仅仅是将枚举对象的name属性输出到结果中，
 * 反序列化的时候则是通过java.lang.Enum的valueOf方法来根据名字查找枚举对象。
 * 同时，编译器是不允许任何对这种序列化机制的定制的，
 * 因此禁用了writeObject、readObject、readObjectNoData、writeReplace和readResolve等方法
 *
 * 3. 枚举实例创建是thread-safe(线程安全的)
 * 当一个Java类第一次被真正使用到的时候静态资源被初始化、
 * Java类的加载和初始化过程都是线程安全的。所以，创建一个enum类型是线程安全的
 *
 * 都是static类型的，因为static类型的属性会在类被加载之后被初始化
 *
 */
public enum  SingletonEnum {
    INSTANCE;
    public void test() {
        System.out.println("SingletonEnum test");
    }
}
