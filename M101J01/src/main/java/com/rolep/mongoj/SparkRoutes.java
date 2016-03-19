package com.rolep.mongoj;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by rolep on 19/03/16.
 */
public class SparkRoutes {

    public static void main(String[] args) {
        Spark.get("/", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return "Hello World\n";
            }
        });

        Spark.get("/test", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return "This is a test page\n";
            }
        });

        Spark.get("/echo/:thing", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return request.params(":thing");
            }
        });
    }
}
