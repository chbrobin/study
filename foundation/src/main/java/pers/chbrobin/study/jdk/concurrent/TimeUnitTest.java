package pers.chbrobin.study.jdk.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by chenhuibin on 2017/6/25 0025.
 * TimeUnit是java.util.concurrent包下面的一个类，表示给定单元粒度的时间段
 * 主要作用
 * 时间颗粒度转换
 * 延时
 */
public class TimeUnitTest {
    public static void main(String[] args) {
//1天有24个小时    1代表1天：将1天转化为小时
        System.out.println( TimeUnit.DAYS.toHours( 1 ) );
        //结果： 24

        //1小时有3600秒
        System.out.println( TimeUnit.HOURS.toSeconds( 1 ));
        //结果3600

        //把3天转化成小时
        System.out.println( TimeUnit.HOURS.convert( 3 , TimeUnit.DAYS ) );
        //结果是：72


        //延时
        new Thread( new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep( 5 );
                    System.out.println( "延时5秒，完成了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
