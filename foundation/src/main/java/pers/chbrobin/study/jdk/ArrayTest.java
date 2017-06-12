package pers.chbrobin.study.jdk;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] i = new int[]{1,2,3};
        System.out.println(i);//存值
        char[] c = new char[]{'a','b','c'};
        System.out.println(c);//存值

        Integer[] ii = new Integer[]{1,2,3};
        System.out.println(ii);//存引用
        String[] cc = new String[]{"a","b","c"};
        System.out.println(cc);//存引用

        // 排序、反转
        Integer[] si = new Integer[]{2,1,3};
        Arrays.sort(si);
        List<Integer> siList = (List<Integer>)Arrays.asList(si);
        Collections.reverse(siList);
        System.out.println(Arrays.toString(si));

        int[] fi = new int[10];
        Arrays.fill(fi,10);
        System.out.println(Arrays.toString(fi));

        System.out.println(Arrays.binarySearch(i,2)); // 1

        int[] ci = new int[20];
        System.arraycopy(i, 0, ci, 4, 3);
        System.out.println(Arrays.toString(ci));

        ci.equals(i);
    }
}
