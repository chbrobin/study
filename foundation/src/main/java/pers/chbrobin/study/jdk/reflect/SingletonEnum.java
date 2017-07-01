package pers.chbrobin.study.jdk.reflect;


import com.sun.javaws.security.Resource;

/**
 * Created by Administrator on 2017/7/1 0001.
 */
public enum  SingletonEnum {
    Instance;

    private ReflectAttackTest instance;

//    SingletonEnum() {
//        singletonEnum = new ReflectAttackTest();
//    }
//
//    public ReflectAttackTest getInstance() {
//        return singletonEnum;
//    }
}