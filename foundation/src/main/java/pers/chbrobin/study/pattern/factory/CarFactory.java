package pers.chbrobin.study.pattern.factory;

/**
 * Created by Administrator on 2017/6/11 0011.
 * 小汽车工厂
 */
public class CarFactory {

    /**
     * 生产小汽车
     */
    public static AbstractCar create(String carName) {
        if("BenzCar".equals(carName)) {
            return new BenzCar();
        } else if("ToyotaCar".equals(carName)) {
            return new ToyotaCar();
        }
        return null;
    }
}
