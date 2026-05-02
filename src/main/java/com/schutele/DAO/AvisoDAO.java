package com.schutele.DAO;


import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class AvisoDAO {

	 public void inserirAviso(String mensagem) {
	        String sql = "INSERT INTO avisos (mensagem) VALUES (?)";

	        try (Connection conn = ConnectionFactory.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, mensagem);
	            stmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<String> listarAvisos() {
	        List<String> lista = new ArrayList<>();
	        String sql = "SELECT mensagem, data_publicacao FROM avisos ORDER BY data_publicacao DESC";

	        try (Connection conn = ConnectionFactory.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                String texto = rs.getString("mensagem");
	                Timestamp data = rs.getTimestamp("data_publicacao");
	                lista.add(texto + " (Publicado em: " + data + ")");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return lista;
	    }
	}
	
