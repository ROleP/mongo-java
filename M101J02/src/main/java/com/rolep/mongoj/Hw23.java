package com.rolep.mongoj;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

/**
 * Created by rolep on 29/03/16.
 */
public class Hw23 {

    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("students");
        MongoCollection<Document> coll = db.getCollection("grades");

        Document search = new Document("type", "homework");
        Document sort = new Document("student_id", 1).append("score", 1);

        Document prev = null;

        for (Document doc : coll.find(search).sort(sort).into(new ArrayList<Document>())) {
            //System.out.println(doc);
            if (prev == null) {
                prev = doc;
                continue;
            }
            if (prev.getInteger("student_id").intValue() == doc.getInteger("student_id").intValue()) {
                System.out.println(1);
                if (prev.getDouble("score").doubleValue() <= doc.getDouble("score").doubleValue())
                coll.deleteOne(prev);
            }
            prev = doc;
        }
    }
}
