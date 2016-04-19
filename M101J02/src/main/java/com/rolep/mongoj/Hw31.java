package com.rolep.mongoj;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

/**
 * Created by rolep on 05/04/16.
 */
public class Hw31 {

    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("school");
        MongoCollection coll = db.getCollection("school");

        ArrayList<Document> ids = new ArrayList<>();

        coll.find().projection(new Document("_id", 1)).into(ids);

        for (Document id : ids) {
            coll.find(id.append("scores.type", "homework"));
            id.get("scores");
        }
        coll.


    }
}
