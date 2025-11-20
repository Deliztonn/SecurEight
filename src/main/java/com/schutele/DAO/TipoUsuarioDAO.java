package com.schutele.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoUsuarioDAO {

    public List<String> buscarTiposUsuario() {
        List<String> tipos = new ArrayList<>();
        String sql = "SELECT DISTINCT tipo_usuario FROM USUARIO ORDER BY tipo_usuario"; 
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                tipos.add(rs.getString("tipo_usuario"));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar tipos de usuário: " + e.getMessage());
            e.printStackTrace();
        }
        return tipos;
    }
}
