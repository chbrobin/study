package pers.chbrobin.study.effectivejava;

import java.util.Arrays;

/**
 * Created by chenhuibin on 2017/7/15 0015.
 * 第27条：返回零长度的数组而不是Null
 */
public class Method27Test {
    public static String[] getStringArr() {
        return new String[]{};
    }
    public static void main(String[] args) {
        String test = "abc";
        System.out.println(Arrays.asList(getStringArr()).contains(test));
    }
}
