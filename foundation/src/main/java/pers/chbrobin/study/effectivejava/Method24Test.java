package pers.chbrobin.study.effectivejava;

import java.util.Date;

/**
 * Created by chenhuibin on 2017/7/15 0015.
 * 第24条：需要时使用保护性拷贝
 *
 * 假设类的客户会尽一切手段来破坏这个类的约束条件,在这样的前提下，必须保护性地设计程序
 * 面对客户不良行为时仍能保持类的健壮性
 *
 * 实例中Period3才是真正的非可变类
 */
public class Method24Test {
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period1 period1 =  new Period1(start, end);
        period1.compare();
        end.setYear(78);
        period1.compare();

        System.out.println("##################################");

        start = new Date();
        end = new Date();
        Period2 period2 =  new Period2(start, end);
        period2.compare();
        period2.getEnd().setYear(78);
        period2.compare();

        System.out.println("##################################");

        start = new Date();
        end = new Date();
        Period3 period3 =  new Period3(start, end);
        period3.compare();
        period3.getEnd().setYear(78);
        period3.compare();
    }

    static public final class Period1 {
        private final Date start;
        private final Date end;

        public Period1(Date start, Date end) {
            boolean flag = start.compareTo(end) > 0;
            System.out.println("Period1 start " + start.getTime() + " end " + end.getTime() + " flag " + flag);
            if(flag)
                throw new IllegalArgumentException(start + " after " + end);

            this.start = start;
            this.end = end;
        }

        public void compare() {
            boolean flag = start.compareTo(end) > 0;
            System.out.println("compare1 start " + start.getTime() + " end " + end.getTime() + " flag " + flag);
            if(start.compareTo(end) > 0) {
                System.out.println("compare1 illegal");
            } else {
                System.out.println("compare1 ok");
            }
        }
    }

    static public final class Period2 {
        private final Date start;
        private final Date end;

        public Period2(Date start, Date end) {
            this.start = new Date(start.getTime());
            this.end = new Date(end.getTime());

            boolean flag = this.start.compareTo(this.end) > 0;
            System.out.println("Period2 start " + start.getTime() + " end " + end.getTime() + " flag " + flag);
            if(flag)
                throw new IllegalArgumentException(start + " after " + end);


        }

        public void compare() {
            boolean flag = start.compareTo(end) > 0;
            System.out.println("compare2 start " + start.getTime() + " end " + end.getTime() + " flag " + flag);
            if(start.compareTo(end) > 0) {
                System.out.println("compare2 illegal");
            } else {
                System.out.println("compare2 ok");
            }
        }

        public Date getEnd() {
            return end;
        }
    }

    static public final class Period3 {
        private final Date start;
        private final Date end;

        public Period3(Date start, Date end) {
            this.start = new Date(start.getTime());
            this.end = new Date(end.getTime());

            boolean flag = this.start.compareTo(this.end) > 0;
            System.out.println("Period3 start " + start.getTime() + " end " + end.getTime() + " flag " + flag);
            if(flag)
                throw new IllegalArgumentException(start + " after " + end);


        }

        public void compare() {
            boolean flag = start.compareTo(end) > 0;
            System.out.println("compare3 start " + start.getTime() + " end " + end.getTime() + " flag " + flag);
            if(start.compareTo(end) > 0) {
                System.out.println("compare3 illegal");
            } else {
                System.out.println("compare3 ok");
            }
        }

        public Date getEnd() {
            return (Date)end.clone();
        }
    }
}


