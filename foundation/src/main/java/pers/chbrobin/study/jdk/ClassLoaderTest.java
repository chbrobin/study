package pers.chbrobin.study.jdk;

import java.net.URL;

/**
 * Created by Administrator on 2017/6/6 0006.
 * BootStrap ClassLoader：称为启动类加载器，是Java类加载层次中最顶层的类加载器，负责加载JDK中的核心类库，如：rt.jar、resources.jar、charsets.jar等
 * Extension ClassLoader：称为扩展类加载器，负责加载Java的扩展类库，默认加载JAVA_HOME/jre/lib/ext/目下的所有jar
 * App ClassLoader：称为系统类加载器，负责加载应用程序classpath目录下的所有jar和class文件
 * 当JVM启动后，Bootstrap ClassLoader也随着启动，负责加载完核心类库后，并构造Extension ClassLoader和App ClassLoader类加载器
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());

        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        System.out.println(classLoaderTest.getClass().getClassLoader());

        System.out.println(new String("abc").getClass().getClassLoader());

        ClassLoader classLoader = new Integer(1).getClass().getClassLoader();
        System.out.println(classLoader.getParent());

        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }

        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(String.class.getClassLoader());

        System.out.println(ClassLoaderTest.class.getClassLoader());
    }
}
