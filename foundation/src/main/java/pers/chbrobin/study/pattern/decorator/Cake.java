package pers.chbrobin.study.pattern.decorator;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public abstract class Cake {
    abstract String getLeftCircleFood();

    abstract String getRightCircleFood();

    void fillFood() {
        System.out.println(getLeftCircleFood() + "||" + getRightCircleFood());
    }
}
