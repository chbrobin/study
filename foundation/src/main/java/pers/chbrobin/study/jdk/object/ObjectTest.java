package pers.chbrobin.study.jdk.object;

/**
 * Created by chenhuibin on 2017/7/12 0012.
 * 如果你要把一个类的对象放入容器中，那么通常要为其重写equals()方法，让他们比较地址值而不是内容值。 collection的contains
 * 特别地，如果要把你的类的对象放入散列中，那么还要重写hashCode()方法；  map put
 * 要放到有序容器中，还要重写compareTo()方法  collection sort
 */
public class ObjectTest {
}
