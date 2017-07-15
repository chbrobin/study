package pers.chbrobin.study.jdk.collection;

import java.util.*;

/**
 * Created by chenhuibin on 2017/7/15 0015.
 */
public class RandomAccessTest {
// 初始化列表

    public static void initList(List list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
    }
//使用循环进行对列表的迭代

    public static void traverseWithLoop(List list) {
        long starttime = 0;
        long endtime = 0;
        starttime = System.currentTimeMillis();
        for (int count = 0; count <= 1000; count++) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i);
            }
        }
        endtime = System.currentTimeMillis();
        System.out.println("使用loop迭代一共花了" + (endtime - starttime) + "ms时间");

    }
//使用迭代器对列表进行迭代

    public static void traverseWithIterator(List list) {
        long starttime = 0;
        long endtime = 0;
        starttime = System.currentTimeMillis();
        for (int count = 0; count <= 1000; count++) {
            for (Iterator itr = list.iterator(); itr.hasNext();) {
                itr.next();
            }
        }
        endtime = System.currentTimeMillis();
        System.out.println("使用Iterator迭代一共花了" + (endtime - starttime) + "ms时间");
    }

    public static void traverse(List list) {

        long starttime = 0;
        long endtime = 0;
        if (list instanceof RandomAccess) {
            System.out.println("该list实现了RandomAccess接口");
            starttime = System.currentTimeMillis();
            for (int count = 0; count <= 1000; count++) {
                for (int i = 0; i < list.size(); i++) {
                    list.get(i);
                }
            }
            endtime = System.currentTimeMillis();
            System.out.println("迭代一共花了" + (endtime - starttime) + "ms时间");
        } else {
            System.out.println("该list未实现RandomAccess接口");
            starttime = System.currentTimeMillis();
            for (int count = 0; count <= 1000; count++) {
                for (Iterator itr = list.iterator(); itr.hasNext();) {
                    itr.next();
                }
            }
            endtime = System.currentTimeMillis();
            System.out.println("迭代一共花了" + (endtime - starttime) + "ms时间");
        }
    }

    public static void main(String[] args) {
        ArrayList arraylist = new ArrayList();
        LinkedList linkedlist = new LinkedList();
        initList(arraylist, 1000);
        initList(linkedlist, 1000);
        traverse(arraylist);
        traverse(linkedlist);
        System.out.println("###################");
        traverseWithIterator(arraylist);
        traverseWithLoop(arraylist);
        System.out.println("###################");
        traverseWithIterator(linkedlist);
        traverseWithLoop(linkedlist);
    }
}
