package org.ogabrielfelipe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorJDBC {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
    private final String username = "postgres";
    private final String password = "200600";

    Connection con;

    public Connection getConnection() throws ClassNotFoundException{
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(jdbcURL, username, password);
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
    }

    public void close() throws Exception{

        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
