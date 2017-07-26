package pers.chbrobin.study.pattern.command.stock;

import org.apache.tools.ant.taskdefs.condition.Or;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhuibin on 2017/7/25 0025.
 */
public class Broker {
    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for(Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
