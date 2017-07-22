package pers.chbrobin.study.pattern.abstractFactory;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public abstract class AbstractFactory {
    static AbstractFactory createFactory(String name) {
        if("middle".equals(name)) {
            return new MiddleFactory();
        } else if("primary".equals(name)) {
            return new PrimaryFactory();
        }
        return null;
    }

    abstract Pen createPen();

    abstract ExerciseBook createExerciseBook();
}
