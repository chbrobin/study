package pers.chbrobin.study.jdk;

import java.io.*;

/**
 * Created by Administrator on 2017/6/1 0001.
 * 如果用transient声明一个实例变量，当对象存储时，它的值不需要维持。
 * 换句话来说就是，用transient关键字标记的成员变量不参与序列化过程
 */
public class TransientTest implements Serializable {
    public transient String pwd;
    public static int staticVar = 5;
    public String name;
    public static void main(String[] args) throws Exception {
        try {
            TransientTest initTt = new TransientTest();
            initTt.setName("aa");
            initTt.setPwd("bb");
            //初始时staticVar为5
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            out.writeObject(initTt);
            out.close();

            System.out.println("initTt toString " + initTt.toString());

            //序列化后修改为10
            TransientTest.staticVar = 10;

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                    "result.obj"));
            TransientTest storeTt = (TransientTest) oin.readObject();
            oin.close();

            //再读取，通过t.staticVar打印新的值
            System.out.println(storeTt.staticVar);
            System.out.println(storeTt.getName());
            System.out.println(storeTt.getPwd());
            System.out.println("storeTt toString " + storeTt.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
