package pers.chbrobin.study.jdk;

/**
 * Created by chenhuibin on 2017/7/10 0010.
 *（1）a被作为编译期全局常量，并不依赖于类，而b作为运行期的全局常量，其值还是依赖于类的。
 *（2）编译时常量在编译时就可以确定值，上例中的a可以确定值，但是b在编译器是不可能确定值的。
 *（3）由于编译时常量不依赖于类，所以对编译时常量的访问不会引发类的初始化。
 */
public class ConstTest {
    private final static int a = 1;
    private final static int b = "".length();
    public static void main(String[] args) {
        System.out.println(a); // 编译后 System.out.println(1); 常a被替换
        System.out.println(b); // 编译后 System.out.println(b); 不变
    }
}
