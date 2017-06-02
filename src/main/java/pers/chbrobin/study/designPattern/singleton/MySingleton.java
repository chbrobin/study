package pers.chbrobin.study.designPattern.singleton;

/**
 * Created by Administrator on 2017/6/1 0001.
 */
public class MySingleton {
    public static MySingleton mySingleton = null;

    public synchronized static MySingleton getInstance() {
        System.out.println("getInstance");
        if(mySingleton == null) {
            mySingleton = new MySingleton();
        }
        return  mySingleton;
    }

    public static void main(String[] args) {
        MySingleton mySingleton = MySingleton.getInstance();

    }
}
