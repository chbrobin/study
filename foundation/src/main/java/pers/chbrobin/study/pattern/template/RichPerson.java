package pers.chbrobin.study.pattern.template;

/**
 * Created by Administrator on 2017/6/11 0011.
 * 富人
 */
public class RichPerson extends AbstractPerson {
    @Override
    public void dressing() {
        System.out.println("穿高端定制衣服");
    }

    @Override
    public void eating() {
        System.out.println("私人厨师做饭");
    }

    @Override
    public void lodging() {
        System.out.println("住别墅");
    }

    @Override
    public void walking() {
        System.out.println("专职司机接送");
    }
}
