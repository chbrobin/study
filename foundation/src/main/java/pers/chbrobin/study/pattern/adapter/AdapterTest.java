package pers.chbrobin.study.pattern.adapter;

/**
 * Created by Administrator on 2017/6/11 0011.
 * 在中国使用日本电器
 */
public class AdapterTest {
    public static void main(String[] args) {
        JapanElectricalAppliance japanElectricalAppliance = new JapanElectricalAppliance();
        JapanVoltage japanVoltage = new JapanVoltageAdapter(new ChinaVoltage());
        System.out.println("japanVoltageAdapter export ev " + japanVoltage.export110V());
        japanElectricalAppliance.selectVoltage(japanVoltage);
        japanElectricalAppliance.work();
    }
}
