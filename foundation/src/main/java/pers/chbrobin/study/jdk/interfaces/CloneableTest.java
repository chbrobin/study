package pers.chbrobin.study.jdk.interfaces;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by chenhuibin on 2017/7/16 0016.
 * 标记接口(Mark Interface)
 * Cloneable和Serializable一样都是标记型接口，它们内部都没有方法和属性，implements Cloneable表示该对象能被克隆，
 * 能使用Object.clone()方法。如果没有implements Cloneable的类调用Object.clone()方法就会抛出CloneNotSupportedException。
 */
public class CloneableTest {
    public static void main(String[] args) {
        List<Cloneable> cloneables = new ArrayList<>();
        cloneables.add(new ArrayList<>());
        cloneables.add(new LinkedList<>());
        cloneables.add(new HashMap<>());
        cloneables.add(new Hashtable<>());

        for(Cloneable cloneable : cloneables) {
            System.out.println(cloneable.getClass());
        }
    }

}
