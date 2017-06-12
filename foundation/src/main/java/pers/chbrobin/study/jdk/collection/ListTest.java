package pers.chbrobin.study.jdk.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/4 0004.
 * add到首部，使用LinkedList
 * add到尾部，使用ArrayList
 * add到中间位置，使用ArrayList
 */
public class ListTest {
    private static int LIST_SIZE = 100000;
    public static void main(String[] args) {
        testAdd("head");
        testAdd("middle");
        testAdd("foot");
    }

    public static void testAdd(String position) {
        Long t1 = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList();
        for(int i = 0; i < LIST_SIZE; i ++) {
            if("head".equals(position)) {
                arrayList.add(0, 1000);
            } else if("middle".equals(position)) {
                arrayList.add(arrayList.size() / 2, 1000);
            } else if("foot".equals(position)) {
                arrayList.add(1000);
            }
        }
        System.out.println("arrayList add " + position + "  arrayList size " + arrayList.size() + " spends " + (System.currentTimeMillis() - t1));

        Long t2 = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for(int i = 0; i < LIST_SIZE; i ++) {
            if("head".equals(position)) {
                linkedList.add(0, 1000);
            } else if("middle".equals(position)) {
                linkedList.add(linkedList.size() / 2, 1000);
            } else if("foot".equals(position)) {
                linkedList.add(1000);
            }
        }
        System.out.println("linkedList add " + position + " linkedList size " + linkedList.size() + " spends " + (System.currentTimeMillis() - t2));
        System.out.println("###################");
    }
}
