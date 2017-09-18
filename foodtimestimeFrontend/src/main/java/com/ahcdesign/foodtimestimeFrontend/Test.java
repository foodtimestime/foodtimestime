package com.ahcdesign.foodtimestimeFrontend;

import static spark.Spark.*;

public class Test {
    public static void main(String[] args) {
//        staticFileLocation("/public");
        staticFileLocation("/react");
        get("/hello", (req, res) -> "Welcome to the Foodtimestime Front End!");
    }
}