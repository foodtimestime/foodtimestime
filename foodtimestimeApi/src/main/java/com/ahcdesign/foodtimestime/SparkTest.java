package com.ahcdesign.foodtimestime;

import static spark.Spark.*;

public class SparkTest {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/hello", (req, res) -> "Hello world, I am Spark!");
    }
}
