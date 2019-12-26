package com.pazz.java.mongodb;

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
public class MongoUtil {

    private static MongoDatabase mongoDatabase;

    private MongoUtil() {
    }

    private static class MongoHolder {
        private static final MongoUtil MONGO_HOLDER = new MongoUtil();
    }

    public static MongoUtil getInstance() {
        return MongoHolder.MONGO_HOLDER;
    }

    /**
     * 获取 mongoDB 连接数据库
     */
    public static MongoDatabase getDatabase(String host, int port, String databaseName) {
        //连接到 mongodb 服务
        if (mongoDatabase == null) {
            // 创建 mongoDB 客户端, 获取数据库
            mongoDatabase = new MongoClient(host, port).getDatabase(databaseName);
        }
        return mongoDatabase;
    }

    /**
     * 根据表名称, 获取 mongo 数据集
     */
    public static MongoCollection getCollection(String name) {
        //连接到数据库
        MongoCollection collection = mongoDatabase.getCollection(name);
        return collection;
    }

}
