package pers.chbrobin.study.pattern.abstractFactory;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class MiddleFactory extends AbstractFactory {
    @Override
    ExerciseBook createExerciseBook() {
        return new EnglishExerciseBook();
    }

    @Override
    Pen createPen() {
        return new FountainPen();
    }
}
