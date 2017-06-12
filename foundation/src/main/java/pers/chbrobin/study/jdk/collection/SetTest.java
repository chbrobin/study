package pers.chbrobin.study.jdk.collection;

import sun.reflect.generics.tree.Tree;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
public class SetTest {
    public static void main(String[] args) {
        // hash存储 查询快
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("ccc");
        hashSet.add("aaa");
        hashSet.add("bbb");
        for(Object s : hashSet.toArray()) {
            System.out.println("hashSet " + s);
        }

        // 排序存储
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("ccc");
        treeSet.add("aaa");
        treeSet.add("bbb");
        for(Object s : treeSet.toArray()) {
            System.out.println("treeSet " + s);
        }

        // 顺序存储
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("ccc");
        linkedHashSet.add("aaa");
        linkedHashSet.add("bbb");
        for(Object s : linkedHashSet.toArray()) {
            System.out.println("linkedHashSet " + s);
        }
    }
}
