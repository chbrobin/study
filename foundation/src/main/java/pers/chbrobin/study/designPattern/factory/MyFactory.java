package pers.chbrobin.study.designPattern.factory;

/**
 * Created by Administrator on 2017/6/2 0002.
 */
public class MyFactory {

    public static Language createLanguage(String language) {
        if("php".equals(language)) {
            return new Php();
        } else if("java".equals(language)) {
            return new Java();
        }
        return null;
    }
}
