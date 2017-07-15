package pers.chbrobin.study.effectivejava;

/**
 * Created by Administrator on 2017/7/15 0015.
 * 重载(overloading)的方法是静态的，而重写(override)是动态的
 * 避免方法重载机制的混淆用法，永远不要使用具有相同参数数目的重载方法
 * 重载方法可以考虑使用相似名字的变形
 * 如果重载方法参数是完全不能互相转型的类型，这种重载是安全的
 * 只要当两个重载方法在同样的参数上被调用时，它们执行的相同的功能，则重载是安全的使用 compareTo equals
 */
public class Method26Test {
    public static void writeLong(Long longValue) {
        System.out.println("writeLong " + longValue);
    }

    public static void writeInt(Integer intValue) {
        System.out.println("writeInt " + intValue);
    }

    public static void main(String[] args) {
        writeInt(new Integer(1));
        writeLong(new Long(1));

        Object str1 = "abc";
        String str2 = new String("abc");
        System.out.println(str1.equals(str2));
        System.out.println(((String)str1).equals(str2));
    }
}
