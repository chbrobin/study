package pers.chbrobin.study.jdk;

import java.util.List;

/**
 * Created by Administrator on 2017/6/2 0002.
 * 寄存器
 * 栈 基本类型 非new字符串
 * 堆 对象
 * String immutability 非可变性
 */
public class StoreTest {

    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        System.out.println("a hashCode " + a.hashCode() + " b hashCode " + b.hashCode());
        System.out.println("a==b result " + (a == b));
        System.out.println();

        String a1 = new String("abc");
        String b1 = new String("abc");
        System.out.println("a1 hashCode " + a1.hashCode() + " b1 hashCode " + b1.hashCode());
        System.out.println("a1==b1 result " + (a1 == b1));
    }
}
