package pers.chbrobin.study.jdk.method;

import java.util.*;

/**
 * Created by Administrator on 2017/7/14 0014.
 */
public class CollectionClass {
    public static void check(Set set){
        System.out.println("set");
    }

    public static void check(List list){
        System.out.println("list");
    }

    public static void check(Collection collection){
        System.out.println("unknow collection");
    }

    public static void main(String[] args) {
        List<Collection> list = new ArrayList<>();
        list.add(new HashSet());
        list.add(new HashSet());
        list.add(new ArrayList());

        for(Collection collection : list) {
            check(collection);
            check(collection);
            check(collection);
            check(collection);
            check(collection);
        }
    }
}
