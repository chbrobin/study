package java;

/**
 * Created by Administrator on 2017/6/3 0003.
 * 用不需查异常强化方法的约定 类似的有NullPointerException IndexOutOfBoundsException 等
 * 可参考java.lang包下 Error & Exception 相关类 主要是RuntimeException
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test(); // throw java.lang.SecurityException
    }
}
