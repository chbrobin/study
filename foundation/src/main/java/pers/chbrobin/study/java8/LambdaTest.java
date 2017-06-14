package pers.chbrobin.study.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Administrator on 2017/6/14 0014.
 */
public class LambdaTest {
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        for(int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

        for(String name : friends) {
            System.out.println(name);
        }

//        friends.forEach(new Consumer<String>() {
//            public void accept(final String name) {
//                System.out.println(name);
//            }
//        });
//        friends.forEach((final String name) -> System.out.println(name));
//
//        new Thread(() -> {
//            System.out.println("test starting ....");
//        }).start();
    }
}
