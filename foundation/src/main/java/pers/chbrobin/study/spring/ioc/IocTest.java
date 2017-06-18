package pers.chbrobin.study.spring.ioc;

/**
 * Created by Administrator on 2017/6/18 0018.
 * 首先想说说IoC（Inversion of Control，控制倒转）。这是spring的核心，贯穿始终。所谓IoC，
 * 对于spring框架来说，就是由spring来负责控制对象的生命周期和对象间的关系。这是什么意思呢，
 * 举个简单的例子，我们是如何找女朋友的？常见的情况是，我们到处去看哪里有长得漂亮身材又好的mm，
 * 然后打听她们的兴趣爱好、qq号、电话号、ip号、iq号………，想办法认识她们，投其所好送其所要，
 * 然后嘿嘿……这个过程是复杂深奥的，我们必须自己设计和面对每个环节。传统的程序开发也是如此，
 * 在一个对象中，如果要使用另外的对象，就必须得到它（自己new一个，或者从JNDI中查询一个），
 * 使用完之后还要将对象销毁（比如Connection等），对象始终会和其他的接口或类藕合起来。

 * 那么IoC是如何做的呢？有点像通过婚介找女朋友，在我和女朋友之间引入了一个第三者：婚姻介绍所。
 * 婚介管理了很多男男女女的资料，我可以向婚介提出一个列表，告诉它我想找个什么样的女朋友，
 * 比如长得像李嘉欣，身材像林熙雷，唱歌像周杰伦，速度像卡洛斯，技术像齐达内之类的，
 * 然后婚介就会按照我们的要求，提供一个mm，我们只需要去和她谈恋爱、结婚就行了。简单明了，
 * 如果婚介给我们的人选不符合要求，我们就会抛出异常。整个过程不再由我自己控制，
 * 而是有婚介这样一个类似容器的机构来控制。Spring所倡导的开发方式就是如此，
 * 所有的类都会在spring容器中登记，告诉spring你是个什么东西，你需要什么东西，
 * 然后spring会在系统运行到适当的时候，把你要的东西主动给你，同时也把你交给其他需要你的东西。
 * 所有的类的创建、销毁都由 spring来控制，也就是说控制对象生存周期的不再是引用它的对象，而是spring。
 * 对于某个具体的对象而言，以前是它控制其他对象，现在是所有对象都被spring控制，所以这叫控制反转。
 * 如果你还不明白的话，我决定放弃。

 * IoC的一个重点是在系统运行中，动态的向某个对象提供它所需要的其他对象。
 * 这一点是通过DI（Dependency Injection，依赖注入）来实现的。比如对象A需要操作数据库，
 * 以前我们总是要在A中自己编写代码来获得一个Connection对象，有了 spring我们就只需要告诉spring，
 * A中需要一个Connection，至于这个Connection怎么构造，何时构造，A不需要知道。在系统运行时，
 * spring会在适当的时候制造一个Connection，然后像打针一样，注射到A当中，
 * 这样就完成了对各个对象之间关系的控制。A需要依赖 Connection才能正常运行，
 * 而这个Connection是由spring注入到A中的，依赖注入的名字就这么来的。那么DI是如何实现的呢？
 * Java 1.3之后一个重要特征是反射（reflection），它允许程序在运行的时候动态的生成对象、
 * 执行对象的方法、改变对象的属性，spring就是通过反射来实现注入的。关于反射的相关资料请查阅java doc
 */
public class IocTest {
    public static void main(String[] args) {

    }
}
