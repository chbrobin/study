package pers.chbrobin.study.pattern.bridge;

/**
 * Created by Administrator on 2017/7/22 0022.
 * 以不同的方式做不同的事情
 * 在不同的事情中委托不同的方式处理
 *
 * 生活实例 如用不同的开关控制不同的电器
 * 代码实例 Log4j不修改代码情况下桥接转换logback
 */
public class BridgeTest {
    public static void main(String[] args) {
        AbstractRoad speedWay = new SpeedWay();
        speedWay.aCar = new Car();
        speedWay.run();

        AbstractRoad street = new Street();
        street.aCar = new Bus();
        street.run();
    }
}
