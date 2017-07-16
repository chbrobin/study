package pers.chbrobin.study.jdk.interfaces;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhuibin on 2017/7/16 0016.
 * 标记接口(Mark Interface)
 * Serializable接口是启用其序列化功能的接口。实现java.io.Serializable 接口的类是可序列化的。
 * 没有实现此接口的类将不能使它们的任一状态被序列化或逆序列化
 */
public class SerializableTest {
    public static void main(String[] args) {
        List<Serializable> serializables = new ArrayList<>();
        serializables.add(new String());
        serializables.add(new Character('a'));
        serializables.add(new String());
        serializables.add(new Byte("1"));
        serializables.add(new Integer(1));
        serializables.add(new Long(1));
        serializables.add(new Float(1));
        serializables.add(new Double(1));
        serializables.add(new Boolean(true));
        serializables.add(new File("."));

        for(Serializable serializable : serializables) {
            System.out.println(serializable.getClass());
        }
    }
}
