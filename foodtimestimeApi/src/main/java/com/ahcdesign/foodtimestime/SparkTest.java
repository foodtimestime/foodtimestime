package com.ahcdesign.foodtimestime;

import static spark.Spark.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SparkTest {
    public static void main(String[] args) {
        port(5678);

        post("/api/v1/random", (request, response) -> {
            return response;
        });
        after((request, response) -> {
            response.type("text/html");
            response.header("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
            response.header("Access-Control-Allow-Headers",
                "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
            response.header("Access-Control-Allow-Origin", "*");
            response.body(fetchRandomMealName());
        });
    }

    private static String fetchRandomMealName() {
        Connection conn;
        String mealName;

        try {
            conn = DbTest.connect();
            String prepQuery = "SELECT mName FROM meals ORDER BY RAND() LIMIT 1";
            PreparedStatement preparedStatement = conn.prepareStatement(prepQuery);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            mealName = result.getString(1);
        } catch (SQLException ex) {
            mealName = "Exception:" + ex;
        }

        return mealName;
    }
}
