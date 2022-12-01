package com.mycompany.poo;

import java.sql.*;

public class conexao {
    private final String url = "jdbc:postgresql://localhost/Poo";
    private final String user = "postgres";
    private final String password = "123456";
    Connection conn = null;

    public Connection connect() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/5432" + url, user, password);
            if (conn != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }
//versão do postgreeSQL
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT VERSION()");
            if (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
