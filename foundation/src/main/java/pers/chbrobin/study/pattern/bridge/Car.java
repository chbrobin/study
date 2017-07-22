package pers.chbrobin.study.pattern.bridge;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class Car extends AbstractCar {
    @Override
    void run() {
        super.run();
        System.out.print("小汽车");
    }
}
