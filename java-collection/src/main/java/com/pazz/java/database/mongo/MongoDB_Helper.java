package com.pazz.java.database.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @author: 彭坚
 * @create: 2019/9/2 17:49
 * @description:
 */
public class MongoDB_Helper {

    private static MongoDatabase mongoDatabase;

    private MongoDB_Helper() {
    }

    private static class MongoUtil {
        private static final MongoDB_Helper DB_HELPER = new MongoDB_Helper();
    }

    public static MongoDB_Helper getInstance() {
        return MongoUtil.DB_HELPER;
    }

    public static MongoDatabase getDatabase(String host, int port, String databaseName) {
        //连接到 mongodb 服务
        if (mongoDatabase == null) {
            mongoDatabase = new MongoClient(host, port).getDatabase(databaseName);
        }
        return mongoDatabase;
    }

    public static MongoCollection getCollection(String name) {
        //连接到数据库
        MongoCollection collection = mongoDatabase.getCollection(name);
        return collection;
    }

    public static void main(String[] args) {
        MongoDB_Helper dbHelper = MongoDB_Helper.getInstance();
        dbHelper.getDatabase("localhost", 27017, "test");
        MongoCollection collection = dbHelper.getCollection("person");
        FindIterable iterable = collection.find();
        MongoCursor cursor = iterable.iterator();
        while(cursor.hasNext()){
            System.out.println(((Document)cursor.next()).get("pname"));
        }
    }

}
