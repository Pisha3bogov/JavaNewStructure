package ru.sapteh.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private Connector() {

    }

    public static Connection getInstance(){
        Connection connection = null;
        PropertyUtil property = new PropertyUtil();

        try {
            Class.forName(property.getProperties("driver"));
            connection = DriverManager.getConnection(
                    property.getProperties("url"),
                    property.getProperties("user"),
                    property.getProperties("password")
                    );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void close(Connection connection) {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
