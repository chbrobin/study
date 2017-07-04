package pers.chbrobin.study.pattern.facade;

/**
 * Created by Administrator on 2017/6/11 0011.
 * 为子系统中的一组接口提供一个统一的接口。Facade模式定义了一个更高的接口，
 * 使子系统更加容易使用。它的意图要求一个一致的高层接口。
 *
 * 应用场景Service对DAO的调用返回业务接口
 *
 *
 * 你要为一个复杂子系统提供一个简单接口时。子系统往往因为不断演化而变得越来越复杂。
 * 大多数模式使用时都会产生更多更小的类。这使得子系 统更具可重用性，
 * 也更容易对子系统进行定制，但这也给那些不需要定制子系统的用户带来一些使用上的困难。
 *
 * 客户程序与抽象类的实现部分之间存在着很大的依赖性。
 * 引入Facade将这个子系统与客户以及其他的子系统分离，
 * 可以提高子系统的独立性和可移植性
 *
 * 当你需要构建一个层次结构的子系统时，使用Facade模式定义子系统中每层的入口点，
 * 如果子系统之间是相互依赖的，你可以让它们仅通过Facade 进行通讯，从而简化了它们之间的依赖关系
 */
public class Facade {
    private ServiceA serviceA;
    private ServiceB serviceB;
    private ServiceC serviceC;

    public Facade(ServiceA serviceA, ServiceB serviceB, ServiceC serviceC) {
        this.serviceA = serviceA;
        this.serviceB = serviceB;
        this.serviceC = serviceC;
    }
    public void methodA() {
        serviceA.methodA();
        serviceB.methodB();
    }
    public void methodB() {
        serviceA.methodA();
        serviceC.methodC();
    }
    public void methodC() {
        serviceB.methodB();
        serviceC.methodC();
    }
}