package pers.chbrobin.study.jdk.string;

/**
 * Created by chenhuibin on 2017/7/10 0010.
 *
 * intern() 方法需要传入一个字符串对象（已存在于堆上），然后检查 StringTable 里是不是已经有一个相同的拷贝。
 * StringTable 可以看作是一个 HashSet，它将字符串分配在永久代上。StringTable
 * 存在的唯一目的就是维护所有存活的字符串的一个对象。如果在 StringTable 里找到了能够找到所传入的字符串对象，
 * 那就直接返回它，否则，把它加入 StringTable ：
 *
 * intern 适合用在需要读取数据并将这些对象或者字符串纳入一个更大范围作用域的情况。
 * 需要注意的是，硬编码在代码中的字符串（例如常量等等）都会被编译器自动的执行 intern 操作
 *
 * 既然 intern() 方法有这些好处，为什么不经常使用呢？原因在于它会降低代码效率
 *
 * 利：节省内存
 * 弊：降低代码效率
 */
public class InternTest {
    public static void main(String[] args) {
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str5.equals(str3));
        System.out.println(str5 == str3);
        System.out.println(str5.intern() == str3);
        System.out.println(str5.intern() == str4);
        System.out.println(str5.intern() == str4.intern());

        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = "a" + "b";
        String e = "b";
        String f = "a" + e;

        System.out.println("");
        System.out.println(b.intern() == a);
        System.out.println(b.intern() == c);
        System.out.println(b.intern() == d);
        System.out.println(b.intern() == f);
        System.out.println(b.intern() == a.intern());
    }
}
