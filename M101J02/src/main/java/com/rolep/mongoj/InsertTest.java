package com.rolep.mongoj;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

/**
 * Created by rolep on 28/03/16.
 */
public class InsertTest {

    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("course");
        MongoCollection<Document> coll = db.getCollection("insertTest");

        coll.drop();

        Document smith = new Document("name", "Smith")
                        .append("age", 30)
                        .append("profession", "programmer");

        Document jones = new Document("name", "Jones")
                        .append("age", 25)
                        .append("profession", "hacker");

        //coll.insertOne(smith);
        coll.insertMany(Arrays.asList(smith, jones));
        coll.find().first();
    }
}
