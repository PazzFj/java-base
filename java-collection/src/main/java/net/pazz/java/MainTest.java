package net.pazz.java;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 * @author: 彭坚
 * @create: 2019/8/1 22:58
 * @description:
 */
public class MainTest {

    public static void main(String[] args) {

        //连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

        MongoCollection collection = mongoDatabase.getCollection("person");

        collection.insertOne(new Document().append("pname", "zhangsan").append("page", "66"));

//        //指定查询过滤器
//        Bson filter = Filters.eq("pname", "admin");
//        //指定查询过滤器查询
//        FindIterable findIterable = collection.find(filter);
//        MongoCursor cursor = findIterable.iterator();
//        while (cursor.hasNext()) {
//            System.out.println(cursor.next());
//        }
//        MongoCollection<Document> collection = mongoDatabase.getCollection("person");
    }

}
