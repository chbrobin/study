package pers.chbrobin.study.jdk.object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhuibin on 2017/7/11 0011.
 * Object hashCode 默认对象地址
 *
 * hashcode方法返回该对象的哈希码值。支持该方法是为哈希表提供一些优点，例如，java.util.Hashtable 提供的哈希表
 *
 * hashCode 的常规官方协定是：
 * 在 Java 应用程序执行期间，在同一对象上多次调用 hashCode 方法时，必须一致地返回相同的整数，前提是对象上 equals 比较中所用的信息没有被修改。从某一应用程序的一次执行到同一应用程序的另一次执行，该整数无需保持一致。
 * 如果根据 equals(Object) 方法，两个对象是相等的，那么在两个对象中的每个对象上调用 hashCode 方法都必须生成相同的整数结果。
 * 以下情况不 是必需的：如果根据 equals(java.lang.Object) 方法，两个对象不相等，那么在两个对象中的任一对象上调用 hashCode 方法必定会生成不同的整数结果。但是，程序员应该知道，为不相等的对象生成不同整数结果可以提高哈希表的性能。
 * 实际上，由 Object 类定义的 hashCode 方法确实会针对不同的对象返回不同的整数。（这一般是通过将该对象的内部地址转换成一个整数来实现的，但是 JavaTM 编程语言不需要这种实现技巧。）
 *
 * 当equals方法被重写时，通常有必要重写 hashCode 方法，以维护 hashCode 方法的常规协定，该协定声明相等对象必须具有相等的哈希码。
 *
 * 可以总结以下关键点
 * 1、hashCode的存在主要是用于查找的快捷性，如Hashtable，HashMap等，hashCode是用来在散列存储结构中确定对象的存储地址的；
 * 2、如果两个对象相同，就是适用于equals(Java.lang.Object) 方法，那么这两个对象的hashCode一定要相同；
 * 3、如果对象的equals方法被重写，那么对象的hashCode也尽量重写，并且产生hashCode使用的对象，一定要和equals方法中使用的一致，否则就会违反上面提到的第2点；
 * 4、两个对象的hashCode相同，并不一定表示两个对象就相同，也就是不一定适用于equals(java.lang.Object) 方法，只能够说明这两个对象在散列存储结构中，如Hashtable，他们“存放在同一个篮子里”。
 *
 * 再归纳
 * 1.hashcode是用来查找的，如果你学过数据结构就应该知道，在查找和排序这一章有
 * 例如内存中有这样的位置
 * 0  1  2  3  4  5  6  7
 * 而我有个类，这个类有个字段叫ID,我要把这个类存放在以上8个位置之一，如果不用hashcode而任意存放，那么当查找时就需要到这八个位置里挨个去找，或者用二分法一类的算法。
 * 但如果用hashcode那就会使效率提高很多。
 * 我们这个类中有个字段叫ID,那么我们就定义我们的hashcode为ID％8，然后把我们的类存放在取得得余数那个位置。比如我们的ID为9，9除8的余数为1，那么我们就把该类存在1这个位置，如果ID是13，求得的余数是5，那么我们就把该类放在5这个位置。这样，以后在查找该类时就可以通过ID除 8求余数直接找到存放的位置了。
 *
 * 2.但是如果两个类有相同的hashcode怎么办那（我们假设上面的类的ID不是唯一的），例如9除以8和17除以8的余数都是1，那么这是不是合法的，回答是：可以这样。那么如何判断呢？在这个时候就需要定义 equals了。
 * 也就是说，我们先通过 hashcode来判断两个类是否存放某个桶里，但这个桶里可能有很多类，那么我们就需要再通过 equals 来在这个桶里找到我们要的类。
 * 那么。重写了equals()，为什么还要重写hashCode()呢？
 * 想想，你要在一个桶里找东西，你必须先要找到这个桶啊，你不通过重写hashcode()来找到桶，光重写equals()有什么用啊
 *
 * 查找，先hashCode定位，再equal查找
 */
public class HashCodeTest {

    public static void main(String[] args) {
        HashCodeTest hashCodeTest = new HashCodeTest();
        System.out.println(hashCodeTest.hashCode());
        System.out.println(Integer.toHexString(hashCodeTest.hashCode()));

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++)
        {
            HashCodeTest hashCodeTestTmp = new HashCodeTest();
            if (!list.contains(hashCodeTestTmp.hashCode())) {
                list.add(hashCodeTestTmp.hashCode());
            }
        }
        System.out.println(list.size());
    }
}
