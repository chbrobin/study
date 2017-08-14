package pers.chbrobin.nosql.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * Created by chenhuibin on 2017/8/11 0011.
 */
public class RedisClientTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("centos-vm1", 6379);
        jedis.auth("robin");

        // string
        jedis.set("name", "foobared");
        String result = jedis.get("myKey");
        System.out.printf("jedis myKey value " + result);

        // list
        List<String> list = jedis.lrange("listkey",0,1000);
        System.out.println("list " + list);

        // set
        jedis.sadd("setkey","abc");
        jedis.sadd("setkey","abc");
        jedis.sadd("setkey","abcd");
        Set<String> set = jedis.smembers("setkey");
        System.out.println("set " + set);

        // hashset
        List<String> maplist =  jedis.hmget("runoobkey","name","visitors");
        System.out.println("map " + maplist);

    }
}
