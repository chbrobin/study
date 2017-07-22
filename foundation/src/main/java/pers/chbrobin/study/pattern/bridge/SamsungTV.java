package pers.chbrobin.study.pattern.bridge;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class SamsungTV implements ITV {
    @Override
    public void on() {
        System.out.println("SumsungTV on");
    }

    @Override
    public void off() {
        System.out.println("SumsungTV off");
    }

    @Override
    public void switchChannel(int channel) {
        System.out.println("SumsungTV switchChannel " + channel);
    }
}
