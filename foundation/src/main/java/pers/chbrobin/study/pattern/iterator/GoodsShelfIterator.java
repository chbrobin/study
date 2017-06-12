package pers.chbrobin.study.pattern.iterator;

/**
 * Created by Administrator on 2017/6/10 0010.
 * 货架迭代器
 * 在实际项目中，GoodsShelfIterator只有在GoodSelf才会用到，通常以内部类的形式存在
 */
public class GoodsShelfIterator implements Iterator {
    private GoodsShelf goodsShelf;
    private int index;

    public GoodsShelfIterator(GoodsShelf goodsShelf) {
        this.goodsShelf = goodsShelf;
        this.index = 0;
    }

    public boolean hasNext() {
        return goodsShelf != null && index < goodsShelf.size();
    }

    public Object next() {
        Goods goods = goodsShelf.get(index);
        index ++;
        return goods;
    }
}
