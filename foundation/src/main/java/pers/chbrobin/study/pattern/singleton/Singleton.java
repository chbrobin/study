package pers.chbrobin.study.pattern.singleton;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class Singleton {
    private static Singleton singleton1 = null;
    private static Singleton singleton2 = null;
    private static Singleton singleton3 = new Singleton();
    private Singleton() {
        //防止被反射
        if(null != singleton1){
            throw new RuntimeException();
        }
    }

    /**
     * 饿汉式
     * 优点：调用效率高
     * 缺点：没有延迟加载，如果它是需要消耗很大内存的对象，最开始就加载入堆内存，而用户暂时不需要。这样就会严重占用堆内存，影响运行效率
     */
    public static Singleton getInstance1() {
        return singleton1;
    }

    /**
     *  懒汉式
     * @return
     */
    public static synchronized Singleton getInstance2() {
        if(singleton2 == null) {
            singleton2 = new Singleton();
        }
        return singleton2;
    }

    /**
     * Double-Checked Locking实现(DCL)
     * 单例模式-双重检查锁
     * 缘由懒汉式、饿汉式要么存在调用效率低或者运行效率低问题。而这两种方式取前两者的优点为自己所用
     */
    public static Singleton getInstance3() {
        if(null == singleton3) {
            synchronized (Singleton.class) {
                if(singleton3 == null) {
                    singleton3 = new Singleton();
                }
            }
        }
        return singleton3;
    }

    private static class InnerClass{
        public static Singleton instance = new Singleton();
    }
    public static Singleton getInstance4(){
        return InnerClass.instance;
    }
}
