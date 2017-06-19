package pers.chbrobin.study.thread.lock;

/**
 * Created by Administrator on 2017/6/19 0019.
 */
class Reader extends Thread {
    private BufferInterruptibly buff;
    public Reader(BufferInterruptibly buff) {
        this.buff = buff;
    }
    @Override
    public void run() {
        try {
            buff.read();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Writer extends Thread {
    private BufferInterruptibly buff;
    public Writer(BufferInterruptibly buff) {
        this.buff = buff;
    }
    @Override
    public void run() {
        buff.write();
    }
}

public class LockTest {
    public static void main(String[] args) {
        BufferInterruptibly buff = new BufferInterruptibly();
        final Reader reader = new Reader(buff);
        final Writer writer = new Writer(buff);
        reader.start();
        writer.start();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 500; i ++) {
                    reader.interrupt();
                    break;
                }
            }
        }).start();
    }
}
