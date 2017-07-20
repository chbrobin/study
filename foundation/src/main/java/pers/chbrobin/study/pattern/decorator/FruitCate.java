package pers.chbrobin.study.pattern.decorator;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public class FruitCate extends Coating {
    public FruitCate(Cake cake) {
        super(cake);
    }

    @Override
    String getLeftCircleFood() {
        return "水果||" + cake.getLeftCircleFood();
    }

    @Override
    String getRightCircleFood() {
        return cake.getLeftCircleFood() + "||水果";
    }
}
