package pers.chbrobin.nosql.mongdb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Created by chenhuibin on 2017/8/13 0013.
 */
public class MongodbJdbc {
    public static void main(String[] args) {
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "10.7.253.92" , 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("Connect to database successfully");

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}

