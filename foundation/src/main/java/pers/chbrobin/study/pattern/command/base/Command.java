package pers.chbrobin.study.pattern.command.base;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public abstract class Command {
    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    abstract void execute();
}
