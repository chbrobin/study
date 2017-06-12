package pers.chbrobin.study.pattern.template;

/**
 * Created by Administrator on 2017/6/11 0011.
 * 穷人
 */
public class PoorPerson extends AbstractPerson {
    @Override
    public void dressing() {
        System.out.println("淘宝网购衣服");
    }

    @Override
    public void eating() {
        System.out.println("自己做饭");
    }

    @Override
    public void lodging() {
        System.out.println("租房住");
    }

    @Override
    public void walking() {
        System.out.println("公交地铁出行");
    }
}
