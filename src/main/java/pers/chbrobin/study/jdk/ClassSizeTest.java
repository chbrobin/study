package pers.chbrobin.study.jdk;

/**
 * Created by Administrator on 2017/6/2 0002.
 */
public class ClassSizeTest {
    private static final Runtime rTime = Runtime.getRuntime();


    public static void main(String []args){
        calSize();
        calSize2();
    }

    private static void calSize() {
        System.out.println("Integer: " + Integer.SIZE/8);			// 4
        System.out.println("Short: " + Short.SIZE/8);				// 2
        System.out.println("Long: " + Long.SIZE/8);					// 8
        System.out.println("Byte: " + Byte.SIZE/8);					// 1
        System.out.println("Character: " + Character.SIZE/8);		// 2
        System.out.println("Float: " + Float.SIZE/8);				// 4
        System.out.println("Double: " + Double.SIZE/8);				// 8
//		System.out.println("Boolean: " + Boolean);
    }

    private static void calSize2() {
        runGC();

        long heap1 = 0;
        final int count = 100000;
        Object[] objs = new Object[count];

        for(int i=-1; i<count; i++) {
            Object obj = null;
            obj = new Object();					// 8
//			obj = new Integer( i );				// 16
//			obj = new Short( (short)i );		// 16
//			obj = new Long( i );				// 16
//			obj = new Byte( (byte)0 );			// 16
//			obj = new Character( (char)i );		// 16
//			obj = new Float( i );				// 16
//			obj = new Double( i );				// 16
//			obj = new Boolean( true );			// 16
//			obj = new String();					// 40


            if(i<0){
                obj = null;
                runGC();
                heap1 = usedMemory();	// before memory size
            } else {
                objs[i] = obj;
            }
        }

        runGC();
        long heap2 = usedMemory();		// after memory size

        final int size = (int)Math.round( (heap2 - heap1)/(double)count );
        System.out.println("heap1 = " + heap1 + "; heap2 = " + heap2);
        System.out.println("heap2-heap1 = " + (heap2 - heap1) + "; " + objs[0].getClass().getSimpleName() + " size = " + size);

        for(int i=0; i<count; i++) {
            objs[i] = null;
        }
        objs = null;
        runGC();
    }

    private static void runGC() {
        for(int i=0; i<4; i++) {
            long usedMem1 = usedMemory();
            long usedMem2 = Long.MAX_VALUE;

            for(int j=0; (usedMem1<usedMem2) && (j<500); j++) {
                rTime.runFinalization();
                rTime.gc();
                Thread.yield();

                usedMem2 = usedMem1;
                usedMem1 = usedMemory();
            }
        }
    }

    private static long usedMemory() {
        return rTime.totalMemory() - rTime.freeMemory();
    }
}
