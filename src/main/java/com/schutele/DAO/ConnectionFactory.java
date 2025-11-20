package com.schutele.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager; // Necessário para o ConnectionFactory


public class ConnectionFactory {

    // --- CONFIGURAÇÕES DO SEU BANCO DE DADOS ---
    // **ATENÇÃO: AJUSTE ESTES VALORES**
    private static final String URL = "jdbc:mysql://localhost:3306/tcc"; 
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    // -------------------------------------------

    /**
     * Retorna uma nova conexão com o banco de dados.
     * @return Objeto Connection
     * @throws SQLException Se ocorrer um erro de acesso ao banco de dados.
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Carrega o driver JDBC. Para MySQL, é o "com.mysql.cj.jdbc.Driver"
            // Para JDBC 4.0+ (Java 6+), esta linha é opcional, mas é bom para garantir.
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (ClassNotFoundException e) {
            // Se o driver não for encontrado, significa que o JAR do driver não está no classpath (pom.xml)
            throw new SQLException("Driver JDBC não encontrado. Verifique se o JAR do driver está no seu projeto.", e);
        }
        
        // Retorna a conexão
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
