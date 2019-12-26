package com.pazz.java.mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

public class Main {

    public static void main(String[] args) {
        MongoUtil dbHelper = MongoUtil.getInstance();
        dbHelper.getDatabase("localhost", 27017, "test");
        MongoCollection collection = dbHelper.getCollection("person");
        FindIterable iterable = collection.find();
        MongoCursor cursor = iterable.iterator();
        while(cursor.hasNext()){
            System.out.println(((Document)cursor.next()).get("pname"));
        }
    }

}
