package pers.chbrobin.study.jdk;

import java.io.*;

/**
 * Created by Administrator on 2017/6/1 0001.
 * 如果用transient声明一个实例变量，当对象存储时，它的值不需要维持。
 * 换句话来说就是，用transient关键字标记的成员变量不参与序列化过程
 *
 * 父类的序列化与 Transient 关键字
 * 一个子类实现了 Serializable 接口，它的父类都没有实现 Serializable 接口，序列化该子类对象，然后反序列化后输出父类定义的某变量的数值，该变量数值与序列化时的数值不同
 *
 * Java 序列化机制为了节省磁盘空间，具有特定的存储规则，当写入文件的为同一对象时，并不会再将对象的内容进行存储，
 * 而只是再次存储一份引用，上面增加的 5 字节的存储空间就是新增引用和一些控制信息的空间。反序列化时，恢复引用关系，
 * 使得清单 3 中的 t1 和 t2 指向唯一的对象，二者相等，输出 true。该存储规则极大的节省了存储空间。
 */
public class SerializableTest implements Serializable {
    private static final long serialVersionUID = 1L;
    public String pwd;
    public static int staticVar = 5;
    public transient String name;
    public static void main(String[] args) throws Exception {
        try {
            SerializableTest initTt = new SerializableTest();
            initTt.setName("aa");
            initTt.setPwd("bb");
            //初始时staticVar为5
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("target/result.obj"));
            out.writeObject(initTt);
            out.close();

            System.out.println("initTt toString " + initTt.toString());

            //序列化后修改为10
//            TransientTest.staticVar = 10;

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                    "target/result.obj"));
            SerializableTest storeTt = (SerializableTest) oin.readObject();
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

    /**
     * 约定方法名
     */
    private void writeObject(ObjectOutputStream out) {
        try {
            ObjectOutputStream.PutField putFields = out.putFields();
            System.out.println("old :" + pwd);
            pwd = "encryption";//模拟加密
            putFields.put("pwd", pwd);
            System.out.println("jiami" + pwd);
            out.writeFields();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 约定方法名
     */
    private void readObject(ObjectInputStream in) {
        try {
            ObjectInputStream.GetField readFields = in.readFields();
            Object object = readFields.get("pwd", "");
            System.out.println("jiemi:" + object.toString());
            pwd = "pass";//模拟解密,需要获得本地的密钥
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