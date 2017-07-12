package pers.chbrobin.study.jdk.innerclass;

/**
 * Created by chenhuibin on 2017/7/13 0013.
 * 匿名类不是外部类的一个成员，
 * 匿名类没有类名，匿名类的使用和实例化仅仅是在那个点上
 */
public class AnonymousClassTest {

    public static void main(String[] args) {

        Thread a = new Thread(new Runnable() {

            @Override

            public void run() {



            }

        });

    }

}
