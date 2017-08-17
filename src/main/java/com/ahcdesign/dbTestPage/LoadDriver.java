package com.ahcdesign.dbTestPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by acooper on 8/16/2017.
 */
public class LoadDriver {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.print(ex.toString());
        }
    }
}
