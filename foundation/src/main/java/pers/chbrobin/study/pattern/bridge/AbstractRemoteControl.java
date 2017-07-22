package pers.chbrobin.study.pattern.bridge;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class AbstractRemoteControl {
    ITV tv;
    public AbstractRemoteControl(ITV tv){
        this.tv = tv;
    }

    public void turnOn(){
        tv.on();
    }

    public void turnOff(){
        tv.off();
    }

    public void setChannel(int channel){
        tv.switchChannel(channel);
    }
}
