package pers.chbrobin.study.jdk;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class CloneTest implements Cloneable {
    public static void main(String[] args) {
        CloneTest ct1 = new CloneTest();
        CloneTest ct2 = ct1.clone();
        System.out.print("ct1 " + ct1.toString());
        System.out.print("ct2 " + ct2.toString());
        ArrayList al1 = new ArrayList();
        al1.add(1);
        al1.add(2);
        ArrayList al2 = (ArrayList)al1.clone();
        ArrayList al3 = al1;
        al1.add(3);
        System.out.print("al1 " + al1.toString());
        System.out.print("al2 " + al2.toString());
        System.out.print("al3 " + al3.toString());
    }

    @SuppressWarnings("unchecked")
    public CloneTest clone() {
        CloneTest cloneTest = new CloneTest();//(CloneTest)super.clone();
        return cloneTest;
    }
}
