package pers.chbrobin.study.pattern.bridge;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class LogitechRemoteControl extends AbstractRemoteControl {
    public LogitechRemoteControl(ITV tv) {
        super(tv);
    }

    public void setChannelKeyboard(int channel){
        setChannel(channel);
        System.out.println("Logitech use keyword to set channel.");
    }
}
