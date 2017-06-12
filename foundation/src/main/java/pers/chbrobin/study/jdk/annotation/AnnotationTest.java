package pers.chbrobin.study.jdk.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class AnnotationTest {
    @MyAnnotation(test = "aaa")
    public void test() {

    }

    public static void main(String[] args) {
        AnnotationTest annotationTest = new AnnotationTest();
        annotationTest.test();

        try {
            for (Method method : AnnotationTest.class
                    .getClassLoader()
                    .loadClass(("pers.chbrobin.study.jdk.annotation.AnnotationTest"))
                    .getMethods()) {
                // checks if MyAnnotation annotation is present for the method
                if (method.isAnnotationPresent(MyAnnotation.class)) {
                    try {
                        // iterates all the annotations available in the method
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method '" + method + "' : " + anno);
                        }
                        MyAnnotation methodAnno = method.getAnnotation(MyAnnotation.class);
                        if (methodAnno.test().equals("aaa")) {
                            System.out.println("Method with test is aaa = " + method);
                        }

                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
