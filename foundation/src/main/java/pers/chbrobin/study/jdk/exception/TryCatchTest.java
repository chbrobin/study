package pers.chbrobin.study.jdk.exception;

/**
 * Created by Administrator on 2017/6/3 0003.
 * try catch 为何还要比无 try catch 要快一些？
 */
public class TryCatchTest {
    private static int increaseTry = 0;
    private static int increaseFinally = 0;
    private static int increaseCommon = 0;
    private static long forSize = 2000000000l;
    public static void testTryMethod() {
        increaseTry = increaseTry * 10;
        testCommonMethod();
    }
    public static void testFinallyMethod() {
        increaseFinally = increaseFinally * 10;
        testCommonMethod();
    }
    public static void testCommonMethod() {
        increaseCommon = increaseCommon * 10;
    }

    public static void noExceptionProcess() {
        Long t1 = System.currentTimeMillis();
        for (int i = 0; i < forSize; i ++) {
            testTryMethod();
            testFinallyMethod();
        }
        System.out.println("no exception spends " + (System.currentTimeMillis() - t1));
    }

    public static void withExceptionProcess() {
        Long t1 = System.currentTimeMillis();
        for (int i = 0; i < forSize; i ++) {
            try {
                testTryMethod();
            } catch (Exception e) {

            } finally {
                testFinallyMethod();
            }
        }
        System.out.println("with exception spends " + (System.currentTimeMillis() - t1));
    }
    public static void main(String[] args) {
        noExceptionProcess();
        withExceptionProcess();
    }
}
