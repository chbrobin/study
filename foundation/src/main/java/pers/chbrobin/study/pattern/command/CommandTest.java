package pers.chbrobin.study.pattern.command;

/**
 * Created by Administrator on 2017/6/11 0011.
 *
 * JDK应用场景
 */
public class CommandTest {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();//电灯、排气扇
        Command command = new CommandImpl(receiver); // 开、关命令
        Invoker i = new Invoker();// 插座开关
        i.setCommand(command);
        i.execute();
    }
}
