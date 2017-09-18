package com.ahcdesign.foodtimestime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbTest {
    private static Connection conn;
    private static String mealName;

    public static void main(String[] args) {
        try {
            conn = connect();
            String prepQuery = "SELECT mName FROM meals WHERE mealid = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(prepQuery);
            preparedStatement.setInt(1, 1);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            mealName = result.getString(1);
        } catch (SQLException ex) {
            mealName = "Exception:" + ex;
        }

        System.out.println(mealName);
    }

    public static Connection connect() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/foodtimestime?" +
                    "user=root&password=trombone7&useSSL=false");
            connection.setSchema("foodtimestime");
            return connection;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }
}
