package pers.chbrobin.study.thread;

/**
 * Created by Administrator on 2017/6/4 0004.
 * main's parent is system
 * thread main group name is main
 */
public class ThreadGroupTest {
    public static void main(String[] args) {
        printGroupInfo(Thread.currentThread());

        Thread appThread = new Thread(new Runnable(){
            public void run() {
                for (int i=0;i<5;i++) {
                    System.out.println("do loop " + i);
                }
            }
        });
        appThread.setName("appThread");
        appThread.start();
        printGroupInfo(appThread);
    }

    static void printGroupInfo(Thread t) {
        ThreadGroup group = t.getThreadGroup();
        System.out.println("thread " + t.getName() + " group name is "
                + group.getName()+ " max priority is " + group.getMaxPriority()
                + " thread count is " + group.activeCount());

        ThreadGroup parent=group;
        do {
            ThreadGroup current = parent;
            parent = parent.getParent();
            if (parent == null) {
                break;
            }

            System.out.println(current.getName() + "'s parent is " + parent.getName());
        } while (true);
        System.out.println("--------------------------");
    }
}
