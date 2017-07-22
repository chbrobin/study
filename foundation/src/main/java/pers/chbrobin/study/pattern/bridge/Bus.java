package pers.chbrobin.study.pattern.bridge;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class Bus extends AbstractCar {
    @Override
    void run() {
        // TODO Auto-generated method stub
        super.run();
        System.out.print("公交车");
    }
}
