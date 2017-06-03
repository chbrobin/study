package pers.chbrobin.study.jdk.exception;

/**
 * Created by Administrator on 2017/6/3 0003.
 * 构造方法中使用异常，注意保证构造函数的原子性
 */
public class StructureTest {
    private static int count = 0;

    public StructureTest() {
        count ++;
        throw new RuntimeException("StructureTest RuntimeException");
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10;  i ++) {
            StructureTest st = null;
            try {
                st = new StructureTest();
            } catch (Exception e) {
//                StructureTest.count --; // 构造方法需要注意原子性操作
                e.printStackTrace(System.err);
            }

            if(st == null) {
                System.out.println("StructureTest null not created");
            }
            System.out.println(StructureTest.count); // 无异常操作回滚，无法保证原子性
        }
    }
}
