package pers.chbrobin.study.jdk;

import java.io.*;

/**
 * Created by Administrator on 2017/6/1 0001.
 */
public class TransientTest implements Serializable {
    public transient String pwd;
    public static int staticVar = 5;
    public String name;
    public static void main(String[] args) throws Exception {
        try {
            TransientTest tt = new TransientTest();
            tt.setName("aa");
            tt.setPwd("bb");
            //初始时staticVar为5
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("D:\\result.obj"));
            out.writeObject(tt);
            out.close();

            System.out.println("tt toString " + tt.toString());

            //序列化后修改为10
            TransientTest.staticVar = 10;

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                    "D:\\result.obj"));
            TransientTest t = (TransientTest) oin.readObject();
            oin.close();

            //再读取，通过t.staticVar打印新的值
            System.out.println(t.staticVar);
            System.out.println(t.getName());
            System.out.println(t.getPwd());
            System.out.println("t toString " + t.toString());

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
