package pers.chbrobin.study.pattern.facade;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class FacadeTest {
    public static void main(String[] args) {
        ServiceA serviceA = new ServiceAImpl();
        ServiceB serviceB = new ServiceBImpl();
        ServiceC serviceC = new ServiceCImpl();
        Facade facade = new Facade(serviceA, serviceB, serviceC);

        facade.methodA();
        facade.methodB();
        facade.methodC();
    }
}
