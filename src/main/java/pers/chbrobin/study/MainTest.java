package pers.chbrobin.study;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class MainTest {
    public static void main(String[] args) {
        if(args != null && args.length > 0) {
            String str = "";
            for(String arg : args) {
                str = str + arg;
            }
            System.out.println("MainTest args is " + str);
            System.out.println("MainTest test jar args is " + StringUtils.join(args));
        } else {
            System.out.println("MainTest args is  null");
        }
    }
}
