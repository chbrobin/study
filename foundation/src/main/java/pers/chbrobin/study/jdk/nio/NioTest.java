package pers.chbrobin.study.jdk.nio;

/**
 * Created by Administrator on 2017/6/5 0005.
 * 它既可以说成“新I/O”，也可以说成非阻塞式I/O
 *
 * 1. 由一个专门的线程来处理所有的 IO 事件，并负责分发
 * 2. 事件驱动机制：事件到的时候触发，而不是同步的去监视事件。
 * 3. 线程通讯：线程之间通过 wait,notify 等方式通讯。保证每次上下文切换都是有意义的。减少无谓的线程切换。
 */
public class NioTest {
}
