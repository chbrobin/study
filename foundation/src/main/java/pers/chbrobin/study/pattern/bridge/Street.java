package pers.chbrobin.study.pattern.bridge;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class Street extends AbstractRoad {
    @Override
    void run() {
        // TODO Auto-generated method stub
        super.run();
        aCar.run();
        System.out.println("在市区街道行驶");
    }
}
