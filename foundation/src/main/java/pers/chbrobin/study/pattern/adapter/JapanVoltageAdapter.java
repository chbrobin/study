package pers.chbrobin.study.pattern.adapter;

/**
 * Created by Administrator on 2017/6/11 0011.
 * 110V变压器
 */
public class JapanVoltageAdapter extends JapanVoltage {
    private ChinaVoltage chinaVoltage;

    public JapanVoltageAdapter(ChinaVoltage chinaVoltage) {
        this.chinaVoltage = chinaVoltage;
    }

    @Override
    public int export110V() {
        return chinaVoltage.export220V() - 110;
    }
}
