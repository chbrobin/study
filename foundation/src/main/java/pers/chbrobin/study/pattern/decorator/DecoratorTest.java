package pers.chbrobin.study.pattern.decorator;

/**
 * Created by chenhuibin on 2017/6/25 0025.
 */
public class DecoratorTest {
    public static void main(String[] args) {
        EggCake eggCake = new EggCake();
        Cake cake1 = new MilkCake(new FruitCate(eggCake));
        cake1.fillFood();

        Cake cake2 = new FruitCate(new MilkCake(eggCake));
        cake2.fillFood();

        Cake cake3 = new MilkCake(new FruitCate(new MilkCake(eggCake)));
        cake3.fillFood();
    }
}