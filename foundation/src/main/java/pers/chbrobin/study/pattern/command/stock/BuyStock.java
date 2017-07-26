package pers.chbrobin.study.pattern.command.stock;

/**
 * Created by chenhuibin on 2017/7/25 0025.
 */
public class BuyStock implements Order {
    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
