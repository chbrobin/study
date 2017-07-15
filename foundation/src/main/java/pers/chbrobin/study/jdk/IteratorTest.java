package pers.chbrobin.study.jdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chenhuibin on 2017/7/15 0015.
 * Iterator 配合for或者while对集合数据做处理，是一种通过的做法
 */
public class IteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList(new String[]{"str1","str2","str3","str4","str5","str6","str7","str8","str9","str10","str11"}));
        List<String> removeList = Arrays.asList(new String[]{"str1","str3","str5","str7","str9"});
        List<String> remove2List = Arrays.asList(new String[]{"str2","str4","str6","str8","str10"});

        for(Iterator<String> iterator1 = list.iterator(); iterator1.hasNext();) {
            System.out.println("str step1 " + iterator1.next());
        }

        Iterator<String> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            if(removeList.contains(iterator2.next())) {
                iterator2.remove();
            }
        }

        System.out.println("############################");

        for(Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            System.out.println("str step2 " + iterator.next());
        }

        for(Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            if(remove2List.contains(iterator.next())) {
                iterator.remove();
            }
        }

        System.out.println("############################");

        for(Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            System.out.println("str step3 " + iterator.next());
        }
    }
}
