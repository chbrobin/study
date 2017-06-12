package pers.chbrobin.study.pattern.command;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class CommandImpl extends Command {
    public CommandImpl(Receiver receiver) {
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.receive();
    }
}
