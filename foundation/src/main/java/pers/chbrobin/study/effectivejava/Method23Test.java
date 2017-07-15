package pers.chbrobin.study.effectivejava;

import java.util.Arrays;

/**
 * Created by chenhuibin on 2017/7/15 0015.
 * 第23条，检查参数的有效性
 *
 * 当编写一个方法或构造函数的时候，应该考虑对它的参数有哪些限制
 * 应该把这些限制写到文档中，并且在这个方法体的起始处，通过显式的检查来实施这些限制
 *
 * 在有些情况下，有效性检查工作非常昂贵，或者根本是不切实际的，并且在计算过程中有效性
 * 检查工作也被隐含着完成了，比如多重方法调用，在最底层方法已经作了检查，上层方法可以不做检查
 */
public class Method23Test {

    public static void main(String[] args) {
        String[] strings = null;
        try {
            testNullPointerException(strings);
        } catch (Exception e) {
            e.printStackTrace();
        }

        strings = new String[]{"abc","def","ghi"};
        testNullPointerException(strings);

        int index = 100;
        try {
            testIndexOutOfBoundsException(strings, index);
        } catch (Exception e) {
            e.printStackTrace();
        }

        index = 3;
        if(strings != null && strings.length >= index - 1) {
            testIndexOutOfBoundsException(strings, index);
        } else {
            System.out.println("testIndexOutOfBoundsException no execute");
        }
    }

    public static void testNullPointerException(String[] strings) {
        if(strings == null) {
            throw new NullPointerException("testNullPointerException");
        }
        System.out.println(Arrays.asList(strings));
    }

    public static void testIndexOutOfBoundsException(String[] strings, int i) {
        if(strings == null) {
            throw new NullPointerException();
        }
        if(i >= strings.length) {
            throw new ArrayIndexOutOfBoundsException("testIndexOutOfBoundsException");
        }
        System.out.println("print strings i " + i + " value " + strings[i]);
    }
}
