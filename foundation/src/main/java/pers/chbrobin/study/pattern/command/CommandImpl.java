package pers.chbrobin.study.pattern.command;

/**
 * Created by Administrator on 2017/6/11 0011.
 * 将一个请求封装为一个对象，从而让我们可用不同的请求对客户进行参数化，
 * 用于“行为请求者”与“行为实现者”解耦，可实现二者之间的松耦合，以便适应变化。
 * 命令模式是一种对象行为型模式，其别名为动作(Action)模式或事务(Transaction)模式
 *
 * JDK应用场景
 * java.lang.Runnable 和 javax.swing.Action是使用命令模式的经典场景
 * @see java.lang.Runnable
 * @see javax.swing.Action
 */
public class    CommandImpl extends Command {
    public CommandImpl(Receiver receiver) {
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.receive();
    }
}
