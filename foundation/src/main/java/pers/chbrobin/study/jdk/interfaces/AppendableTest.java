package pers.chbrobin.study.jdk.interfaces;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhuibin on 2017/7/16 0016.
 * Appendable接口的实现类的对象能够被添加 char 序列和值。如果某个类的实例打算接收取自
 * java.util.Formatter 的格式化输出，那么该类必须实现 Appendable 接口。 * 要添加的字符应该是有效的 Unicode 字符。
 * Appendable 对于多线程访问而言没必要是安全的。线程安全由扩展和实现此接口的类负责。
 * 所有已知实现类：
 * BufferedWriter, CharArrayWriter, CharBuffer, FileWriter, FilterWriter, LogStream, OutputStreamWriter,
 * PipedWriter, PrintStream, PrintWriter, StringBuffer, StringBuilder, StringWriter, Writer
 */
public class AppendableTest {
    public static void main(String[] args) throws Exception {
        List<Appendable> appendables = new ArrayList<>();
        appendables.add(new StringBuffer(""));
        appendables.add(new StringBuilder(""));
        appendables.add(new BufferedWriter(new FileWriter(new File("D:\\a.txt"))));

        for(Appendable appendable : appendables) {
            System.out.println(appendable.getClass());
        }
    }
}
