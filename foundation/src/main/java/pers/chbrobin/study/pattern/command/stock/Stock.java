package pers.chbrobin.study.pattern.command.stock;

/**
 * Created by chenhuibin on 2017/7/25 0025.
 */
public class Stock {
    private String name = "TestStock";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock buy name " + name + " quantity " + quantity);
    }

    public void sell() {
        System.out.println("Stock sell name " + name + " quantity " + quantity);
    }
}
