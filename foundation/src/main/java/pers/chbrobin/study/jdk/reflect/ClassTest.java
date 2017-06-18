package pers.chbrobin.study.jdk.reflect;

/**
 * Created by Administrator on 2017/6/18 0018.
 */
public class ClassTest {
    private String name;
    public ClassTest() {
        this.name = "test";
    }

    @Override
    public String toString() {
       return super.toString() + "name is " + name;
    }

    public static Object newInstance(String className) {
        Class<?> cls = null;
        Object obj = null;
        try {
            cls = Class.forName(className);
            obj = cls.newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public static void main(String[] args) {
        System.out.println(newInstance("pers.chbrobin.study.jdk.reflect.ClassTest"));
    }
}
