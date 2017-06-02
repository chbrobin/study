package pers.chbrobin.study.jdk;

import java.io.*;

/**
 * Created by Administrator on 2017/6/1 0001.
 * �����transient����һ��ʵ��������������洢ʱ������ֵ����Ҫά�֡�
 * ���仰��˵���ǣ���transient�ؼ��ֱ�ǵĳ�Ա�������������л�����
 *
 * ��������л��� Transient �ؼ���
 * һ������ʵ���� Serializable �ӿڣ����ĸ��඼û��ʵ�� Serializable �ӿڣ����л����������Ȼ�����л���������ඨ���ĳ��������ֵ���ñ�����ֵ�����л�ʱ����ֵ��ͬ
 *
 * Java ���л�����Ϊ�˽�ʡ���̿ռ䣬�����ض��Ĵ洢���򣬵�д���ļ���Ϊͬһ����ʱ���������ٽ���������ݽ��д洢��
 * ��ֻ���ٴδ洢һ�����ã��������ӵ� 5 �ֽڵĴ洢�ռ�����������ú�һЩ������Ϣ�Ŀռ䡣�����л�ʱ���ָ����ù�ϵ��
 * ʹ���嵥 3 �е� t1 �� t2 ָ��Ψһ�Ķ��󣬶�����ȣ���� true���ô洢���򼫴�Ľ�ʡ�˴洢�ռ䡣
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
            //��ʼʱstaticVarΪ5
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            out.writeObject(initTt);
            out.close();

            System.out.println("initTt toString " + initTt.toString());

            //���л����޸�Ϊ10
//            TransientTest.staticVar = 10;

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                    "result.obj"));
            SerializableTest storeTt = (SerializableTest) oin.readObject();
            oin.close();

            //�ٶ�ȡ��ͨ��t.staticVar��ӡ�µ�ֵ
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
     * Լ��������
     */
    private void writeObject(ObjectOutputStream out) {
        try {
            ObjectOutputStream.PutField putFields = out.putFields();
            System.out.println("old :" + pwd);
            pwd = "encryption";//ģ�����
            putFields.put("pwd", pwd);
            System.out.println("jiami" + pwd);
            out.writeFields();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Լ��������
     */
    private void readObject(ObjectInputStream in) {
        try {
            ObjectInputStream.GetField readFields = in.readFields();
            Object object = readFields.get("pwd", "");
            System.out.println("jiemi:" + object.toString());
            pwd = "pass";//ģ�����,��Ҫ��ñ��ص���Կ
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
