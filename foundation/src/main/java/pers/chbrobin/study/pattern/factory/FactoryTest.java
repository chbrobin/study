package pers.chbrobin.study.pattern.factory;

/**
 * Created by Administrator on 2017/6/11 0011.
 * 驾驶小汽车
 */
public class FactoryTest {
    public static void main(String[] args) {
        AbstractCar benzCar = CarFactory.create("BenzCar");
        benzCar.drive();

        AbstractCar toyotaCar = CarFactory.create("ToyotaCar");
        toyotaCar.drive();
    }
}
