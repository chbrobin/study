package pers.chbrobin.study.pattern.command;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class CommandTest {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new CommandImpl(receiver);
        Invoker i = new Invoker();
        i.setCommand(command);
        i.execute();
    }
}
