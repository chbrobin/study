package pers.chbrobin.study.jdk.reflect;

/**
 * Created by chenhuibin on 2017/7/1 0001.
 * 懒汉式单例
 */
public class Singleton {
    private static boolean flag = false;
    private static final Singleton INSTANCE = new Singleton();
    private Singleton() {
        synchronized (Singleton.class) {
            if (false == flag) {
                flag = !flag;
            } else {
                throw new RuntimeException("单例模式正在被攻击");
            }
        }
    }
    public static Singleton newInstance() {
        return INSTANCE;
    }
}
