package pers.chbrobin.study.jdk.clone;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/3 0003.
 * 什么时候使用shallow Clone，什么时候使用deep Clone，这个主要看具体对象的域是什么性质的，基本型别还是reference variable
 * 调用Clone()方法的对象所属的类(Class)必须implements Clonable接口，否则在调用Clone方法的时候会抛出CloneNotSupportedException。
 */
public class CloneTest implements Cloneable {
    private static boolean isCloneDate = false;
    private SubCloneObject subCloneObject;

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest ct1 = new CloneTest();
        SubCloneObject subCloneObject = new SubCloneObject(1000L);
        ct1.subCloneObject = subCloneObject;

        CloneTest ct2 = (CloneTest)ct1.clone();
        CloneTest.isCloneDate = true;
        CloneTest ct3 = (CloneTest)ct1.clone();
        ct1.subCloneObject.setLongVar(2000L);
        System.out.println("ct1 " + ct1.toString() + " subCloneObject " + ct1.subCloneObject.toString() + " longVar " + ct1.subCloneObject.getLongVar());
        System.out.println("ct2 " + ct2.toString() + " subCloneObject " + ct2.subCloneObject.toString() + " longVar " + ct2.subCloneObject.getLongVar());
        System.out.println("ct3 " + ct3.toString() + " subCloneObject " + ct3.subCloneObject.toString() + " longVar " + ct3.subCloneObject.getLongVar());

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
    public Object clone() throws CloneNotSupportedException {
        CloneTest cloneTest = (CloneTest)super.clone();
        if(isCloneDate) {
            cloneTest.subCloneObject = (SubCloneObject) subCloneObject.clone();
        }
        return cloneTest;
    }
}
