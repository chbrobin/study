package pers.chbrobin.study.pattern.command.stock;

/**
 * Created by chenhuibin on 2017/7/25 0025.
 */
public class SellStock implements Order {
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
