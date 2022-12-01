package com.mycompany.poo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Inserir {
    private final String url = "jdbc:postgresql://localhost/Poo";
    private final String user = "postgres";
    private final String password = "123456";
    private static final String insert_usuario_sql = "insert into usuario" + "  (coduser, name, sobrenome, email, idade, telefone, nome usuario, senha, cpf) VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static void main(String[] argv) throws SQLException {
        Inserir createTableExample = new Inserir();
        createTableExample.insertRecord();
    }
    public void insertRecord() throws SQLException {

        System.out.println(insert_usuario_sql);
// Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/5432" + url, user, password);
// Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(insert_usuario_sql)) {
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "ana");
            preparedStatement.setString(3, "carla");
            preparedStatement.setString(4, "anacarla@gmail.com");
            preparedStatement.setString(5, "12");
            preparedStatement.setString(6, "31234235467");
            preparedStatement.setString(7, "aninha");
            preparedStatement.setString(8, "1212121");
            preparedStatement.setString(9, "12312312312");
            System.out.println(preparedStatement);
// Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
// print SQL exception information
            printSQLException(e);
        }
// Step 4: try-with-resource statement will auto close the connection.
    }
    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

