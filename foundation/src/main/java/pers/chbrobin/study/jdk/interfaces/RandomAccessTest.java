package pers.chbrobin.study.jdk.interfaces;

import java.util.*;

/**
 * Created by chenhuibin on 2017/7/16 0016.
 * 标记接口(Mark Interface)
 * RandomAccess接口是List 实现所使用的标记接口，用来表明其支持快速（通常是固定时间）随机访问。
 * 此接口的主要目的是允许一般的算法更改其行为，从而在将其应用到随机或连续访问列表时能提供良好的性能
 *
 * @see Collections#reverse(List)
 * @see Collections#shuffle(List)
 * @see Collections#fill(List, Object)
 * @see Collections#binarySearch(List, Object)
 * @see Collections#fill(List, Object)
 */
public class RandomAccessTest {
    public static void main(String[] args) {
        List<RandomAccess> randomAccesses = new ArrayList<>();
        randomAccesses.add(new ArrayList<>());
        randomAccesses.add(new Vector<>());
        randomAccesses.add(new Stack<>());

        for(RandomAccess randomAccess : randomAccesses) {
            System.out.println(randomAccess.getClass());
        }
    }
}
