package pers.chbrobin.study.jdk;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("a","a");
        map.put("b","b");
        map.put("c","c");
        Collection<String> collection = map.values();
        for(String s : collection) {
            System.out.println(s);
        }
    }
}
