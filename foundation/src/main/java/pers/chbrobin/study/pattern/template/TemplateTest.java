package pers.chbrobin.study.pattern.template;

/**
 * Created by Administrator on 2017/6/11 0011.
 * JDK场景
 * java.io.InputStream, java.io.OutputStream, java.io.Reader 以及 java.io.Writer 中所有非抽象方法。
 * java.util.AbstractList, java.util.AbstractSet 以及 java.util.AbstractMap中所有非抽象方法
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
