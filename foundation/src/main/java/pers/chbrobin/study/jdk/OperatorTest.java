package pers.chbrobin.study.jdk;

/**
 * Created by chenhuibin on 2017/7/1 0001.
 * byte     8
 * boolean  8
 * short    16
 * int      32
 * long     64
 * float    32
 * double   64
 * char     16
 * <<:  左移运算符，num << 1,相当于num乘以2
 * >>:  右移运算符，num >> 1,相当于num除以2
 * >>>: 无符号右移，忽略符号位，空位都以0补齐
 * &:   位与，第一个操作数的的第n位于第二个操作数的第n位如果都是1，那么结果的第n为也为1，否则为0 （两个都是1才为1）
 * |:   位或，第一个操作数的的第n位于第二个操作数的第n位 只要有一个是1，那么结果的第n为也为1，否则为0 (有一个1就为1)
 * ^:   位异或，第一个操作数的的第n位于第二个操作数的第n位 相反，那么结果的第n为也为1，否则为0 (相反为1 相同为0)
 * ~:   位非，操作数的第n位为1，那么结果的第n位为0，反之。
 */
public class OperatorTest {
    public static void main(String[] args) {
        // 1、左移( << )
        // 0000 0000 0000 0000 0000 0000 0000 0101 然后左移2位后，低位补0：//
        // 0000 0000 0000 0000 0000 0000 0001 0100 换算成10进制为20
        left(5, 2); // 5 << 2 运行结果是20

        // 2、右移( >> ) 高位补符号位
        // 0000 0000 0000 0000 0000 0000 0000 0101 然后右移2位，高位补0：
        // 0000 0000 0000 0000 0000 0000 0000 0001
        right(5, 2); // 5 >> 2 运行结果是1

        // 3、无符号右移( >>> ) 高位补0
        // 例如 -5换算成二进制后为：0101 取反加1为1011
        // 1111 1111 1111 1111 1111 1111 1111 1011
        // 我们分别对5进行右移3位、 -5进行右移3位和无符号右移3位：
        right(5, 3);// 5 >> 3 结果是0
        right(-5, 3);// -5 >> 3  结果是-1
        rightPlus(-5, 3);// -5 >>> 3  结果是536870911

        // 4、位与( & )
        // 位与：第一个操作数的的第n位于第二个操作数的第n位如果都是1，那么结果的第n为也为1，否则为0
        and(5, 3);// 5 & 3 结果为1
        and(4, 1);// 4 & 1 结果为0

        // 5、位或( | )
        // 第一个操作数的的第n位于第二个操作数的第n位 只要有一个是1，那么结果的第n为也为1，否则为0
        or(5, 3);// 5 | 3 结果为7

        // 6、位异或( ^ )
        // 第一个操作数的的第n位于第二个操作数的第n位 相反，那么结果的第n为也为1，否则为0
        bitOr(5, 3);// 5 ^ 3 结果为6

        // 7、位非( ~ )
        // 操作数的第n位为1，那么结果的第n位为0，反之。
        bitNot(5);// ~5 结果为-6
    }

    private static void left(int base, int count) {
        System.out.println(base + "<<" + count);
        System.out.println(intToBitString(base));
        int num = base << count;
        System.out.println(intToBitString(num));
        System.out.println();
    }

    private static void right(int base, int count) {
        System.out.println(base + ">>" + count);
        System.out.println(intToBitString(base));
        int r = base >> count;
        System.out.println(intToBitString(r));
        System.out.println();
    }

    private static void rightPlus(int base, int count) {
        System.out.println(base + ">>>" + count);
        System.out.println(intToBitString(base));
        int r = base >>> count;
        System.out.println(intToBitString(r));
        System.out.println();
    }

    private static void and(int a, int b) {
        System.out.println(a + "&" + b);
        System.out.println(intToBitString(a));
        System.out.println(intToBitString(b));
        int r = a & b;
        System.out.println(intToBitString(r));
        System.out.println();
    }

    private static void or(int a, int b) {
        System.out.println(a + "|" + b);
        System.out.println(intToBitString(a));
        System.out.println(intToBitString(b));
        int r = a | b;
        System.out.println(intToBitString(r));
        System.out.println();
    }

    private static void bitOr(int a, int b) {
        System.out.println(a + "^" + b);
        System.out.println(intToBitString(a));
        System.out.println(intToBitString(b));
        int r = a ^ b;
        System.out.println(intToBitString(r));
        System.out.println();
    }

    private static void bitNot(int base) {
        System.out.println("~" + base);
        System.out.println(intToBitString(base));
        int r = ~ base;
        System.out.println(intToBitString(r));
        System.out.println();
    }

    private static String intToBitString(int num) {
        String s = Integer.toBinaryString(num);
        int l = s.length();
        StringBuffer sb = new StringBuffer();
        if(l > 0) {
            for(int i = 0; i < 32 - l; i ++) {
                sb.append("0");
            }
        }
        sb.append(s);
        StringBuffer sbr =  new StringBuffer();
        for(int i = 0; i < sb.length();i ++) {
            if(i % 4 == 0 && i > 0) {
                sbr.append(" ");
            }
            sbr.append(sb.charAt(i));
        }
        return sbr.toString();
    }
}
/**
 1.  判断int型变量a是奇数还是偶数
 a&1  = 0 偶数
 a&1 =  1 奇数
 2.  求平均值，比如有两个int类型变量x、y,首先要求x+y的和，再除以2，但是有可能x+y的结果会超过int的最大表示范围，所以位运算就派上用场啦。
 (x&y)+((x^y)>>1);
 3.  对于一个大于0的整数，判断它是不是2的几次方
 ((x&(x-1))==0)&&(x!=0)；
 4.  比如有两个int类型变量x、y,要求两者数字交换，位运算的实现方法：性能绝对高效
 x ^= y;
 y ^= x;
 x ^= y;
 5. 求绝对值
 int abs( int x )
 {
 int y ;
 y = x >> 31 ;
 return (x^y)-y ;        //or: (x+y)^y
 }
 6.  取模运算，采用位运算实现：
 a % (2^n) 等价于 a & (2^n - 1)
 7.  乘法运算   采用位运算实现
 a * (2^n) 等价于 a << n
 8.   除法运算转化成位运算
 a / (2^n) 等价于 a>> n
 9.   求相反数
 (~x+1)
 10  a % 2 等价于 a & 1
 */