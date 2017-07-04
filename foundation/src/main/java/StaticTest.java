/**
 * Created by Administrator on 2017/6/10 0010.
 */
public class StaticTest {
    private String aa;

    public StaticTest(String aa) {
        this.aa = aa;
    }

    // 与这个对象的成员没有关联引用
    public static void print(String aa) {
        System.out.println(aa);
    }

    public void print() {
        System.out.println(aa);
    }

    public static void main(String[] args) {
        StaticTest staticTest = new StaticTest("bbbbb");
        StaticTest.print(staticTest.aa);
    }
}
