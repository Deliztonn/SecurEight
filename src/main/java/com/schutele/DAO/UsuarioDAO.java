package com.schutele.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.schutele.model.Usuario;

public class UsuarioDAO {

    public Usuario validarLogin(String email, String senha) {

        // CORREÇÃO FINAL: Usando o nome EXATO da coluna 'tipo_usuario' e dando um ALIAS 'tipo'
        String sql = "SELECT nome, tipo_usuario AS tipo FROM cadastro WHERE email = ? AND senha = ?";
        Usuario usuario = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/tcc";
            String usuarioDB = "root";
            String senhaDB = "1234";

            try (Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
                 PreparedStatement stmt = conexao.prepareStatement(sql)) {

                stmt.setString(1, email);
                stmt.setString(2, senha);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String nome = rs.getString("nome");
                        // Lendo pelo ALIAS 'tipo'
                        String tipo = rs.getString("tipo"); // O valor será "adm" ou "usuario"
                        usuario = new Usuario(nome, tipo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario; 
    }
}
