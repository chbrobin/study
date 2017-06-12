package pers.chbrobin.study.pattern.factory;

/**
 * Created by Administrator on 2017/6/11 0011.
 * 抽象小汽车
 */
public abstract class AbstractCar {

    private String name;

    public AbstractCar(String name) {
        this.name = name;
    }

    /**
     * 驾驶小汽车
     */
    public void drive() {
        System.out.println("driving " + name);
    }
}
