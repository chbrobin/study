package pers.chbrobin.study.jdk.syntacticSugar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/6/24 0024.
 */
public class SyntacticSugarTest {
    public static void main(String[] args) {
        // 1 泛型
        List<String> stringList = new ArrayList<String>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        System.out.println(stringList.get(0).substring(0,1));

        // 2 自动装箱和折箱
        Integer a = 1;
        System.out.println(a == 1);

        // 3 foreach循环
        for(String aa : new String[]{"a","b","c"}) {
            System.out.println(aa);
        }

        // 4 变长参数
        System.out.println(Arrays.asList("a", "b", "c"));
        testArgs("a", "b", "c");

        // 5 条件编译
        if(true) {
            System.out.println("a");
        } else {
            System.out.println("b");
        }

        // 6 内部类
        System.out.println(new InnerClass());

        // 7 枚举类
        System.out.println(EnumTest.MALE);

        // 8 断言
        String str = "fans2";
        boolean flag = "fans".equals(str);
        assert (flag);

        // 9 对枚举和字符串的switch支持
        String switchStr = "aa";
        switch (switchStr) {
            case "aa":
                System.out.println("aaaaaaaaaaa");
            case "bb":
                System.out.println("bbbbbbbbbbb");
            default:
                System.out.println("ccccccccccc");
        }

        EnumTest enumTest = EnumTest.FEMALE;
        enumTest.values();
        switch (enumTest) {
            case FEMALE:
                System.out.println("femail");
            case MALE:
                System.out.println("male");
            default:
                System.out.println("other");
        }

        // 10 在try语句中定义和关闭资源
        try {
            readFirstLineFromFile(SyntacticSugarTest.class.getClassLoader().getResource("test.txt").getPath());
            SyntacticSugarTest.class.getClassLoader().getResource("test.txt").toURI();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        // jdk 1.7 新特性
        int i = 0b0011; int j = 0b0011_0101;
    }

    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    private static void testArgs(String... strs) {
        for(String str : strs) {
            System.out.println(str);
        }
    }
}

class InnerClass {

}

