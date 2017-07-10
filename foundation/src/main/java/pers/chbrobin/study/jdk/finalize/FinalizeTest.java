package pers.chbrobin.study.jdk.finalize;

import java.io.FileOutputStream;

/**
 * Created by chenhuibin on 2017/7/10 0010.
 * 一、慎用finalize方法
 * 在垃圾回收的时候，某个对象要被回收的时候，会先进行一次标记，并且将该对象的finalize放到一个低优先级的线程中去执行。
 * 等到下一次垃圾回收的时候再把这个对象回收 jvm并不保证在垃圾回收之前能够执行他的finalize方法，
 * 甚至在执行finalize方法的线程发生了死循环，那其他的finalize方法都无法执行了。
 *
 * 二、如何替代finalize方法
 * 使用try...finally...代码块，将要执行的后续操作放入到finally块中
 *
 * 三、finalize方法一定没有吗
 * 在一些必须要做清楚的操作中，比如说InputStream,我们都知道执行完了得把流关掉 为了避免用户的误操作，
 * 可以在InputStream的finalize方法中关闭流，这样为资源的释放增加了一层保护网，虽然不保证一定能够执行
 *
 * 四、终结方法链？
 * 有些时候可能遇到这样的情况  class Super中有一个close方法需要最后执行，
 * 所以在Super类中的finalize方法中是这样的
 * @Override
 * protected void finalize() throws Throwable(){
 * this.close();
 * }
 * 但是class Sub extends Super的时候，子类把Super的finalize方法给重写了，
 * 不再调用super.finalize()，那就完蛋了，super的finalize方法肯定不会被执行了。
 * @Override
 * protected void finalize() throws Throwable(){
 * try{
 * //finalize subclass state
 * }finally{
 * super.finalize();
 * }
 * }
 *
 * 当然我们并不能保证来继承super类的人能够这样写，所以有个更好的方法：
 * 使用一个finalizerGuardian：
 * [java] view plain copy
 * public class Super{
 * //...
 *
 * private final Object finalizerGuardian=new Object(){
 * @Override
 * protected void finalize() throws Throwable(){
 * //Super.this.close();
 * }
 * }
 *
 * }
 *
 * 父类被回收的时候，内部的匿名类也一定被收回，那匿名内部类的finalize方法不管子类怎么搞都不会受影响的。是不是很巧妙。
 */
public class FinalizeTest {
    private static FinalizeTest SAVE_HOOK = null;
    private FileOutputStream fo;
    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeTest();
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (null != SAVE_HOOK) { //此时对象应该处于(reachable, finalized)状态
            System.out.println("Yes , I am still alive");
        } else {
            System.out.println("No , I am dead");
        }
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (null != SAVE_HOOK) {
            System.out.println("Yes , I am still alive");
        } else {
            System.out.println("No , I am dead");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("execute method finalize()");
        SAVE_HOOK = this;

        if(fo != null) {
            fo.close();
        }
    }
}
