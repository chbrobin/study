package pers.chbrobin.study.jdk.innerclass;

/**
 * Created by chenhuibin on 2017/7/13 0013.
 * 非静态成员类可以通过“外部类名.this.变量”来访问外部类的静态变量，
 * 方法则是直接访问外部类的方法；如果外部类的方法要访问非静态成员类，则需要生成一个非静态成员变量的实例
 *
 * 对象建立才加载 ，随着对象的建立而加载，随着对象的消失而消失
 * 存放于栈内存中
 * 只能被对象名调用，不能用类名调用
 *
 * 非静态的一个类就会包含一个
 */
public class NoStaticMemberClassTest {

    private int a = 2;
    private static int b= 11;



    class NoStaticMemberClass {

        public void doMethod1() {

            int a = 3;

            doMethod();

            System.out.println("doMethod1. a=" + NoStaticMemberClassTest.this.a);
            System.out.println("doMethod1. a=" + b);

        }

    }



    public void doMethod() {

        System.out.println("doMethod");

    }



    public static void main(String[] args) {

        NoStaticMemberClassTest n = new NoStaticMemberClassTest();

        n.doMethod();

        NoStaticMemberClass nsmc = new NoStaticMemberClassTest().new NoStaticMemberClass();

        nsmc.doMethod1();

    }

}
