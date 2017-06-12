package pers.chbrobin.study.pattern.template;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class TemplateTest {
    public static void main(String[] args) {
        AbstractPerson richPerson = new RichPerson();
        AbstractPerson poorPerson = new PoorPerson();
        System.out.println("############### rich person living ###############");
        richPerson.living();
        System.out.println("############### poor person living ###############");
        poorPerson.living();
    }
}
