package pers.chbrobin.study.pattern.iterator;

/**
 * Created by Administrator on 2017/6/11 0011.
 * 货架
 */
public class GoodsShelf implements Aggregate {
    private Goods[] goodses;
    private int index;
    private static int GROWING_SIZE = 100;

    public void add(Goods goods) {
        if(goodses == null) {
            goodses = new Goods[GROWING_SIZE];
            goodses[0] = goods;
        } else {
            if(index < goodses.length) {
                goodses[index] = goods;
            } else {
                System.out.println("index " + index + " length " + goodses.length);
                Goods[] copyGoodses = new Goods[goodses.length + GROWING_SIZE];
                System.arraycopy(goodses, 0, copyGoodses, 0, goodses.length);
                copyGoodses[goodses.length] = goods;
                goodses = copyGoodses;
            }
        }
        index ++;
    }

    public Goods get(int index) {
        return goodses[index];
    }

    public Integer size() {
        return goodses.length;
    }

    public Iterator iterator() {
        return new GoodsShelfIterator(this);
    }
}
