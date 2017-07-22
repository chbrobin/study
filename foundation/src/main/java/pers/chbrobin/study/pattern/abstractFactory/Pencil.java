package pers.chbrobin.study.pattern.abstractFactory;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class Pencil implements Pen {
    @Override
    public void writeWord() {
        System.out.println("use Pencil writeWord!");
    }
}
