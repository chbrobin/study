package pers.chbrobin.study.jdk.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by chenhuibin on 2017/7/16 0016.
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<Collection> collections = new ArrayList<>();
        collections.add(new ArrayList());

        for(Collection collection : collections) {
            System.out.println(collection.getClass());
        }
    }
}
