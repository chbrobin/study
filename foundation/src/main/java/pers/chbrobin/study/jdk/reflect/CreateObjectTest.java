package pers.chbrobin.study.jdk.reflect;

import pers.chbrobin.study.jdk.string.StringTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by chenhuibin on 2017/7/19 0019.
 */
public class CreateObjectTest {
    public static void main(String[] args) {
        try {
            String test = String.class.getConstructor(String.class).newInstance("test");
            Method method = String.class.getMethod("toString");
            System.out.println(method.invoke(test));
            System.out.println(test.hashCode());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
