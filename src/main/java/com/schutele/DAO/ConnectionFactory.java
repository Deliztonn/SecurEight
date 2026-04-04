package com.schutele.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager; // Necessário para o ConnectionFactory


public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/tcc"; 
    private static final String USER = "root";
    private static final String PASSWORD = "Chibatada";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado. Verifique se o JAR do driver está no seu projeto.", e);
        }
     
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
