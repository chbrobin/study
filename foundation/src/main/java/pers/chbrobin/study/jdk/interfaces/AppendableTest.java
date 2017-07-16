package pers.chbrobin.study.jdk.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhuibin on 2017/7/16 0016.
 */
public class AppendableTest {
    public static void main(String[] args) {
        List<Appendable> appendables = new ArrayList<>();
        appendables.add(new StringBuffer(""));
        appendables.add(new StringBuilder(""));

        for(Appendable appendable : appendables) {
            System.out.println(appendable.getClass());
        }
    }
}
