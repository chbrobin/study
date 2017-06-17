package pers.chbrobin.study.pattern.flyweight;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/16 0016.
 */
public class FoodFactory {
    public static Map<String, Food> map = new HashedMap();

    public static Food getFood(String name) {
        Food food = map.get(name);
        if(food != null) {
            return food;
        }
        food = new Food();
        food.setName(name);
        if(Food.NODDLE.equals(name)) {
            food.setPrice(100);
        } else {
            food.setPrice(200);
        }
        map.put(name, food);
        return  food;
    }
}
