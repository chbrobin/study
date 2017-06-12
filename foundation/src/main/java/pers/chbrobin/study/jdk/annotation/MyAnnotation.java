package pers.chbrobin.study.jdk.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface MyAnnotation {
    String test();
}
