package pers.chbrobin.study.jdk.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/6/17 0017.
 * 主要用来做方法的增强，让你可以在不修改源码的情况下，
 * 增强一些方法，在方法执行前后做任何你想做的事情（甚至根本不去执行这个方法），
 * 因为在InvocationHandler的invoke方法中，你可以直接获取正在调用方法对应的Method对象，
 * 具体应用的话，比如可以添加调用日志，做事务控制
 *
 * 在很多底层框架中都会用得到，比如struts，Spring等都用到了动态代理，它的作用很简单，
 * 就是将你要使用的类，重新生成一个子类或本类，这样框架就可以利用这个新生成的类做一些事情，
 * 比如在该类的方法前后加一些代码
 *
 * Proxy类的代码量被固定下来，不会因为业务的逐渐庞大而庞大；
 * 可以实现AOP编程，实际上静态代理也可以实现，总的来说，AOP可以算作是代理模式的一个典型应用；
 * 解耦，通过参数就可以判断真实类，不需要事先实例化，更加灵活多变。
 *
 * 缺点 对于final方法，无法进行代理
 */
public class CglibProxy implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        methodProxy.invokeSuper(o, args);
        return null;
    }
}
