package com.mycompany.poo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateTableExample {
    private final String url = "jdbc:postgresql://localhost/Poo";
    private final String user = "postgres";
    private final String password = "123456";
    private static final String createTableSQL = "CREATE TABLE usuario " +
            "(cod usuario int PRIMARY KEY ," + " Nome varchar(100), " + " Sobrenome varchar(100), " + " Email varchar(100), " + " Idade int, " + "Telefone char(50)," + " Nome usuario varchar(100) , " + " senha int, " + " Cpf char(50))";
    public static void main(String[] argv) throws SQLException {
        CreateTableExample createTableExample = new
                CreateTableExample();
        createTableExample.createTable();
    }
    public void createTable() throws SQLException {
        System.out.println(createTableSQL);
// Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user,
                password);
// Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {
// Step 3: Execute the query or update query
            statement.execute(createTableSQL);
        } catch (SQLException e) {
// print SQL exception information
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException e) {
    }
}
