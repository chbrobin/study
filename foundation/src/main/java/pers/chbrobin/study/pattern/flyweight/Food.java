package pers.chbrobin.study.pattern.flyweight;

/**
 * Created by Administrator on 2017/6/16 0016.
 */
public class Food {
    public static String NODDLE = "noddle";
    public static String RICE = "rice";

    private String name;
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public static Food valueOf(String name) {
        return  FoodFactory.getFood(name);
    }

    @Override
    public String toString() {
        return super.toString() + "name is " + name + " price is " + price;
    }
}