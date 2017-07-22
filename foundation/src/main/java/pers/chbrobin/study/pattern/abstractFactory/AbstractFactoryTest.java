package pers.chbrobin.study.pattern.abstractFactory;

/**
 * Created by chenhuibin on 2017/6/25 0025.
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory primary = AbstractFactory.createFactory("primary");
        System.out.println(primary.createExerciseBook());
        System.out.println(primary.createPen());

        System.out.println("###########################");

        AbstractFactory middle = AbstractFactory.createFactory("middle");
        System.out.println(middle.createExerciseBook());
        System.out.println(middle.createPen());
    }
}
