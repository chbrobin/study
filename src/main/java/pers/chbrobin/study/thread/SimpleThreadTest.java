package pers.chbrobin.study.thread;

/**
 * Created by Administrator on 2017/6/7 0007.
 * 创建非静态内部类实例，必须通过该对象实例new
 * obj.new InnerObject();
 */
public class SimpleThreadTest {
    public class Mm {
        public volatile Long field;

        public void editField(Long field) {
            this.field = field;
        }

        public Long fethcField() {
            return this.field;
        }
    }

    public class Mt implements Runnable {
        private Mm mm;

        public Mt(Mm mm) {
            this.mm = mm;
            new Thread(this).start();
        }
        public void run() {
            for(int i = 0; i < 10; i ++) {
                mm.editField(Long.valueOf(i));
            }
            System.out.println("fethcField " + mm.fethcField());
        }
    }


    public static void main(String[] args) {
        SimpleThreadTest simpleThreadTest = new SimpleThreadTest();
        Mt mt = simpleThreadTest.new Mt(simpleThreadTest.new Mm());
    }
}
