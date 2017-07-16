package pers.chbrobin.study.jdk.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhuibin on 2017/7/16 0016.
 *
 * CharSequence就是字符序列
 * CharSequence是一个接口，它只包括length(), charAt(int index), subSequence(int start, int end)这几个API接口
 */
public class CharSequenceTest {
    public static void main(String[] args) {
        List<CharSequence> charSequences = new ArrayList<>();
        charSequences.add(new String("abc"));
        charSequences.add(new StringBuffer("abc"));
        charSequences.add(new StringBuilder("abc"));

        new Character('a');

        for(CharSequence charSequence : charSequences) {
            System.out.println(charSequence.charAt(0));
            System.out.println(charSequence.getClass());
        }
    }
}
