package pers.chbrobin.study.pattern.bridge;

/**
 * Created by Administrator on 2017/7/22 0022.
 * 桥接模式允许两层实现的抽象，上面的电视机和遥控器就是很好的例子。
 * 可见，桥接模式提供了更多的灵活性。
 */
public class BridgeTest {
    public static void main(String[] args){
        ITV tv = new SonyTV();
        LogitechRemoteControl lrc = new LogitechRemoteControl(tv);
        lrc.setChannelKeyboard(100);
    }
}
