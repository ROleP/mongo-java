package com.rolep.mongoj;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.halt;

/**
 * Created by rolep on 19/03/16.
 */
public class HelloWorldSparkFreemarkerStyle {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");

        Spark.get("/", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                StringWriter writer = new StringWriter();
                try {
                    Template helloTemplate = configuration.getTemplate("hello.ftl");
                    Map<String, Object> helloMap = new HashMap<>();
                    helloMap.put("name", "Freemarker");

                    helloTemplate.process(helloMap, writer);
                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }
                return writer;
            }
        });
    }
}
