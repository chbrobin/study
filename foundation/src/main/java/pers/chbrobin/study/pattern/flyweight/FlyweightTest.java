package pers.chbrobin.study.pattern.flyweight;

/**
 * Created by Administrator on 2017/6/16 0016.
 * 有效率地存储大量的小的对象
 *
 * JDK应用场景
 * @see java.lang.Integer#valueOf(int)
 * @see java.lang.Boolean#valueOf(boolean)
 * @see java.lang.Byte#valueOf(byte)
 * @see java.lang.Character#valueOf(char)
 */
public class FlyweightTest {
    public static void main(String[] args) {
        Food noddle1 = Food.valueOf(Food.NODDLE);
        System.out.println("noddle1 " + noddle1);

        Food noddle2 = Food.valueOf(Food.NODDLE);
        System.out.println("noddle2 " + noddle2);

        Food rice1 = Food.valueOf(Food.RICE);
        System.out.println("rice1 " + rice1);

        Food rice2 = Food.valueOf(Food.RICE);
        System.out.println("rice2 " + rice2);
    }
}
