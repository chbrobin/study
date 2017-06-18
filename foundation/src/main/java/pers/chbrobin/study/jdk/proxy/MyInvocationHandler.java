package pers.chbrobin.study.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/6/17 0017.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler() {
        super();
    }
    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        return  result;
    }
}
