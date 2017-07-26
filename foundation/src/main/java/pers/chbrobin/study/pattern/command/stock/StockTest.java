package pers.chbrobin.study.pattern.command.stock;

/**
 * Created by chenhuibin on 2017/7/25 0025.
 */
public class StockTest {
    public static void main(String[] args) {
        Broker broker = new Broker();
        Stock stock = new Stock();
        broker.takeOrder(new BuyStock(stock));
        broker.takeOrder(new SellStock(stock));

        broker.placeOrders();
    }
}
