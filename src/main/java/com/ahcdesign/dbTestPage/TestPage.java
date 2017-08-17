package com.ahcdesign.dbTestPage;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by acooper on 8/16/2017.
 */
public class TestPage extends WebPage {
    private static final long serialVersionUID = 1L;
    private Connection conn;
    private String schema;

    public TestPage(final PageParameters parameters) {
        super(parameters);
        connect();
        try {
            conn.setSchema("foodtimestime");
            schema = conn.getSchema();
        } catch (SQLException ex) {
            System.out.println("Exception:" + ex.getCause().toString());
        }

        add(new Label("schema", schema));
        add(new Label("connection", conn.toString()));
    }

    private void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/foodtimestime?" +
            "user=root&password=trombone7&useSSL=false");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
