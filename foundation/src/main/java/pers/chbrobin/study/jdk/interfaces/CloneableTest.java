package pers.chbrobin.study.jdk.interfaces;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by chenhuibin on 2017/7/16 0016.
 *
 * 拷贝接口
 */
public class CloneableTest {
    public static void main(String[] args) {
        List<Cloneable> cloneables = new ArrayList<>();
        cloneables.add(new ArrayList<>());
        cloneables.add(new LinkedList<>());
        cloneables.add(new HashMap<>());
        cloneables.add(new Hashtable<>());

        for(Cloneable cloneable : cloneables) {
            System.out.println(cloneable.getClass());
        }
    }

}
