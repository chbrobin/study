package pers.chbrobin.study.jdk.innerclass;

/**
 * Created by chenhuibin on 2017/7/13 0013.
 * 非静态成员类可以通过“外部类名.this.变量”来访问外部类的静态变量，
 * 方法则是直接访问外部类的方法；如果外部类的方法要访问非静态成员类，
 * 则需要生成一个非静态成员变量的实例。
 *
 * 优先于对象存在，随着类的加载而加载，随着类的消失而消失
 * 存放于方法区中
 * 可以直接被类名调用
 *
 * 静态的所有类只会存储一个
 */
public class StaticMemberClassTest {

    private static int a;

    private int b;



    private static class StaticMemberClass {

        public void doMethod1() {

            System.out.println("doMethod1. a=" + a);

        }

    }



    public void doMethod() {

        StaticMemberClass s = new StaticMemberClass();

        s.doMethod1();

        System.out.println("doMethod.");

    }



    public static void main(String[] args) {

        StaticMemberClassTest s = new StaticMemberClassTest();

        s.doMethod();

    }

}