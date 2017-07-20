package pers.chbrobin.study.pattern.decorator;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public class MilkCake extends Coating {
    public MilkCake(Cake cake) {
        super(cake);
    }

    @Override
    String getLeftCircleFood() {
        return "奶油||" + cake.getLeftCircleFood();
    }

    @Override
    String getRightCircleFood() {
        return cake.getRightCircleFood() + "||奶油";
    }
}
