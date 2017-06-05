package pers.chbrobin.study.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/5 0005.
 * 在一个线程中调用other.join(),将等待other执行完后才继续本线程
 */
public class JoinThreadTest {
    public static void main(String[] args) {
        List<String> resList = new ArrayList<String>();
        List<JoinThread> threads = new ArrayList<JoinThread>();
        for(int i=0;i<3;i++){
            JoinThread thread = new JoinThread("Thread" + i);
            thread.start();
            threads.add(thread);
        }
        for (JoinThread thread : threads) {
            try {
                //主线程等待时间不超过10秒，若超过，则主线程直接走
                thread.join(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i=0;i<threads.size();i++) {
            List<String> result = threads.get(i).getResult();
            if(result.size()==0 && threads.get(i).isAlive()){
                threads.get(i).interrupt();//中断超时的线程
            }else{
                resList.addAll(result);
            }
        }
        System.out.println("结果如下：\n" + resList);
    }
}
