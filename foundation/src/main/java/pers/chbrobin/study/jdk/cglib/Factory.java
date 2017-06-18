package pers.chbrobin.study.jdk.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by Administrator on 2017/6/17 0017.
 */
public class Factory {
    public static Base getInstance(CglibProxy proxy) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Base.class);
        enhancer.setCallback(proxy);
        Base base = (Base)enhancer.create();
        return base;
    }
}
