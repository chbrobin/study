package pers.chbrobin.study.pattern.bridge;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class SonyTV implements ITV {
    @Override
    public void on() {
        System.out.println("SonyTV on");
    }

    @Override
    public void off() {
        System.out.println("SonyTV off");
    }

    @Override
    public void switchChannel(int channel) {
        System.out.println("SonyTV switchChannel " + channel);
    }
}