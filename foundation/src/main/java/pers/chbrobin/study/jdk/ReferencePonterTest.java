package pers.chbrobin.study.jdk;

/**
 * Created by Administrator on 2017/7/5 0005.
 * 基本类型变量，包括char、byte、short、int、long、float、double、boolean。
 * 引用类型变量，包括类、接口、数组（基本类型数组和对象数组）。
 *
 * 1、基本类型和基本类型变量被当作参数传递给方法时，是值传递。在方法实体中，无法给原变量重新赋值，也无法改变它的值。
 * 2、对象和引用型变量被当作参数传递给方法时，是引用传递。在方法实体中，无法给原变量重新赋值，但是可以改变它所指向对象的属性。
 *
 * 传值指的是传递java基本类型
 * 传引用指的是传递java的堆中数据
 * 因为很显然，你不能将int ,long这些基本类型的东西叫做“指针”，
 * 我理解的java的引用，就是安全指针。
 *
 * Java里的传值实际上是拷贝引用，而不是拷贝对象
 */
public class ReferencePonterTest {
    // 初始值为0  
    protected int num = 0;

    // 为方法参数重新赋值  
    public void change(int i) {
        i = 5;
    }

    // 为方法参数重新赋值  
    public void change(ReferencePonterTest t) {
        ReferencePonterTest tmp = new ReferencePonterTest();
        tmp.num = 9;
        t = tmp;
    }

    // 改变方法参数的值  
    public void add(int i) {
        i += 10;
    }

    // 改变方法参数属性的值  
    public void add(ReferencePonterTest pt) {
        pt.num += 20;
    }

    public static void main(String[] args) {
        ReferencePonterTest t = new ReferencePonterTest();

        // 为基本类型参数重新赋值  
        t.change(t.num);
        System.out.println(t.num);
        // 为引用型参数重新赋值  
        t.change(t);
        System.out.println(t.num);

        // 改变基本类型参数的值  
        t.add(t.num);
        System.out.println(t.num);
        // 改变引用类型参数所指向对象的属性值  
        t.add(t);
        System.out.println(t.num);
    }
}
