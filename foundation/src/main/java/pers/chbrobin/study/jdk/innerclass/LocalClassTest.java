package pers.chbrobin.study.jdk.innerclass;

/**
 * Created by Administrator on 2017/7/13 0013.
 * 局部类是放在方法中的，不访问外部类方法中的局部变量，
 * 除非变量被声明为final的
 */
public class LocalClassTest {

    private int a = 2;



    public void method() {

        final int b = 3;

        class LocalClass {

            public void method1() {

                System.out.println("method1. b=" + b);

            }

        }

        LocalClass l = new LocalClass();

        l.method1();

    }



    public static void main(String[] args) {

        LocalClassTest l = new LocalClassTest();

        l.method();

        System.out.println(l.a);

    }

}


