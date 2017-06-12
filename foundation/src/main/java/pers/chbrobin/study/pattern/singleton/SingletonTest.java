package pers.chbrobin.study.pattern.singleton;

import java.lang.reflect.Constructor;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class SingletonTest {
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 100000; i ++ ) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Singleton singleton1 = Singleton.getInstance1();
                    System.out.println("singleton1 " + singleton1);
                    Singleton singleton2 = Singleton.getInstance2();
                    System.out.println("singleton2 " + singleton2);
                    Singleton singleton3 = Singleton.getInstance3();
                    System.out.println("singleton3 " + singleton3);
                    Singleton singleton4 = Singleton.getInstance4();
                    System.out.println("singleton4 " + singleton4);
                    SingletonEnum singleton5 = SingletonEnum.INSTANCE;
                    System.out.println("singleton5 " + singleton5);
                }
            });
            thread.start();
        }

        // 从安全纬度考虑，依然隐隐约约存在问题
        Singleton clazzOne=Singleton.getInstance2();
        Singleton clazzTwo=Singleton.getInstance2();

        System.out.println("clazzOne-hasCode:"+clazzOne.hashCode());
        System.out.println("clazzTwo-hasCode:"+clazzTwo.hashCode());

        Class<Singleton> clazz=(Class<Singleton>)Class.forName("singleton.Singleton");
        Constructor<Singleton> c = clazz.getConstructor(null);
        c.setAccessible(true);
        Singleton clazzThree=c.newInstance();
        Singleton clazzFour=c.newInstance();
        System.out.println("clazzThree-hasCode:"+clazzThree.hashCode());
        System.out.println("clazzFour-hasCode:"+clazzFour.hashCode());
    }

}
