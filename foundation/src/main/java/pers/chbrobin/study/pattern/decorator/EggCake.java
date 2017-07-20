package pers.chbrobin.study.pattern.decorator;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public class EggCake extends Cake {

    @Override
    String getLeftCircleFood() {
        return "面粉";
    }

    @Override
    String getRightCircleFood() {
        return "面粉";
    }
}
