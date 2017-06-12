package pers.chbrobin.study.pattern.command;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }
}
