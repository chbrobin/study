package pers.chbrobin.study.jdk.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhuibin on 2017/7/16 0016.
 * 异常基本接口
 */
public class ThrowableTest {

    public static void main(String[] args) {
        List<Throwable> throwables = new ArrayList<>();
        throwables.add(new Exception());
        throwables.add(new Error());

        for(Throwable throwable : throwables) {
            System.out.println(throwable.getClass());
        }
    }
}
