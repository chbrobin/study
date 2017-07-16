package pers.chbrobin.study.jdk.interfaces;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhuibin on 2017/7/16 0016.
 *
 * 此接口强行对实现它的每个类的对象进行整体排序。此排序被称为该类的自然排序 ，类的 compareTo 方法被称为它的自然比较方法 。
 * 实现此接口的对象列表（和数组）可以通过 Collections.sort （和 Arrays.sort ）进行自动排序。
 * 实现此接口的对象可以用作有序映射表中的键或有序集合中的元素，无需指定比较器。
 * 强烈推荐（虽然不是必需的）使自然排序与 equals 一致。所谓与equals一致是指对于类 C 的每一个 e1 和 e2 来说，
 * 当且仅当 (e1.compareTo((Object)e2) == 0) 与e1.equals((Object)e2) 具有相同的布尔值时，类 C 的自然排序才叫做与 equals 一致 。
 *
 */
public class ComparableTest {
    public static void main(String[] args) {
        List<Comparable> comparables = new ArrayList<>();
        comparables.add(new Character('a'));
        comparables.add(new String());
        comparables.add(new Byte("1"));
        comparables.add(new Integer(1));
        comparables.add(new Long(1));
        comparables.add(new Float(1));
        comparables.add(new Double(1));
        comparables.add(new Boolean(true));
        comparables.add(new File("."));

        for(Comparable comparable : comparables) {
            System.out.println(comparable.getClass());
        }
    }
}
