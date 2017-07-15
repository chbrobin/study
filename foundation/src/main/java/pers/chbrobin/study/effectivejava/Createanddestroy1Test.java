package pers.chbrobin.study.effectivejava;

/**
 * Created by chenhuibin on 2017/7/15 0015.
 * 第1条：考虑用静态工厂方法代替构造函数
 *
 * 优点
 * 1、与构造函数不同，静态工厂方法具有名字
 * 2、与构造函数不同，它们每次被调用的时候，不要求非得创建一个新的对象
 * 3、与构造函数不同，它们可以返回一个原返回类型的子类型的对象
 *
 * 缺点
 * 1、类如果不含公有的或者受保护的构造函数，就不能被子类化
 * 2、它们与其他的静态方法没有任何区别
 */
public class Createanddestroy1Test {

    public static Boolean valueOf(boolean b){
        return (b ? Boolean.TRUE : Boolean.FALSE);
    }

    public static void main(String[] args) {
        Boolean booleanFlag = valueOf(true);
        System.out.println(booleanFlag);
    }
}
