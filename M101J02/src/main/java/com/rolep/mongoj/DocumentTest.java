package com.rolep.mongoj;

import org.bson.Document;

/**
 * Created by rolep on 28/03/16.
 */
public class DocumentTest {

    public static void main(String[] args) {
        Document document = new Document()
                .append("str", "MongoDB, Hello")
                .append("int", 42);

        String str = document.getString("str");
        int i = document.getInteger("int");

    }
}
