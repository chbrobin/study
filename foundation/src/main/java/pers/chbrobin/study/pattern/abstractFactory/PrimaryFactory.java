package pers.chbrobin.study.pattern.abstractFactory;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class PrimaryFactory extends AbstractFactory {
    @Override
    ExerciseBook createExerciseBook() {
        return new MathExerciseBook();
    }

    @Override
    Pen createPen() {
        return new Pencil();
    }
}
