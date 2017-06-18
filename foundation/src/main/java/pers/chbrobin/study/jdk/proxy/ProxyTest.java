package pers.chbrobin.study.jdk.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/6/17 0017.
 */
public class ProxyTest {
    public static void main(String[] args) {
        Service service = new MyService();
        MyInvocationHandler handler = new MyInvocationHandler(service);
        Service proxyService = (Service)Proxy.newProxyInstance(service.getClass().getClassLoader(),service.getClass().getInterfaces(),handler);
        System.out.println("proxyService " + proxyService);
        proxyService.add();
        proxyService.update();

    }
}
