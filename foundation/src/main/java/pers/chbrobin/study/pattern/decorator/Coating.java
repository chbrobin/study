package pers.chbrobin.study.pattern.decorator;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public abstract class Coating extends Cake {
    Cake cake;

    Coating(Cake cake) {
        this.cake = cake;
    }
}
