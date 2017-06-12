package pers.chbrobin.study.pattern.adapter;

/**
 * Created by Administrator on 2017/6/11 0011.
 * 日本电器
 */
public class JapanElectricalAppliance {
    private JapanVoltage japanVoltage;

    public void selectVoltage(JapanVoltage japanVoltage) {
        this.japanVoltage = japanVoltage;
    }

    public void work() {
        if(japanVoltage.export110V() == 110) {
            System.out.println("start working");
        } else {
            System.out.println("can not work");
        }
    }
}
