package pers.chbrobin.study.pattern.iterator;

/**
 * Created by Administrator on 2017/6/10 0010.
 * 扫描货架测试类
 */
public class IteratorTest {
    public static void main(String[] args) {
        GoodsShelf goodsShelf = new GoodsShelf();
        for(int i = 0; i < 10000; i ++) {
            Goods goods = new Goods("goods" + i);
            goodsShelf.add(goods);
        }

        Iterator iterator = goodsShelf.iterator();
        while (iterator.hasNext()) {
            Goods goods = (Goods) iterator.next();
//            System.out.println("goods name is " + goods.getName());
        }
    }
}