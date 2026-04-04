package com.schutele.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.schutele.model.Usuario;

public class UsuarioDAO {

    public Usuario validarLogin(String email, String senha) {

        // BUSCA TODAS AS COLUNAS CORRETAS DO SEU BANCO
        String sql = "SELECT matricula, nome, bloco, ap, email, senha, tipo_usuario " +
                     "FROM cadastro WHERE email = ? AND senha = ?;";

        Usuario usuario = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/tcc";
            String usuarioDB = "root";
            String senhaDB = "Chibatada";

            try (Connection conexao = DriverManager.getConnection(url, usuarioDB, senhaDB);
                 PreparedStatement stmt = conexao.prepareStatement(sql)) {

                stmt.setString(1, email);
                stmt.setString(2, senha);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {

                        usuario = new Usuario(
                                rs.getString("matricula"),
                                rs.getString("nome"),
                                rs.getString("bloco"),
                                rs.getString("ap"),
                                rs.getString("senha"),
                                rs.getString("email"),
                                rs.getString("tipo_usuario")
                        );

                        usuario.setId(rs.getInt("matricula"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }
    
    public void cadastrarUsuario(Usuario u) {
    	
        //AES_ENCRYPT(? ,'8bolas'),
        String sql = "INSERT INTO cadastro (matricula, nome, bloco, ap, email, senha, tipo_usuario) VALUES (?, ?, ?, ?, ?,AES_ENCRYPT(? ,'8bolas'), ?)";
        
        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                
            stmt.setString(1, u.getMatricula());   
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getBloco());
            stmt.setString(4, u.getAp());
            stmt.setString(5, u.getEmail());
            stmt.setString(6, u.getSenha());
            stmt.setString(7, u.getTipoUsuario()); 
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
            e.printStackTrace();
		}
	}
    
    //======================= COISAS DA CAHVE =======================
    
    public List<Usuario> listarTodos() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT matricula, nome, bloco, ap, email, tipo_usuario, estado FROM cadastro";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario(
                    rs.getString("matricula"),
                    rs.getString("nome"),
                    rs.getString("bloco"),
                    rs.getString("ap"),
                    "", // senha não trazemos aqui
                    rs.getString("email"),
                    rs.getString("tipo_usuario")
                );
                u.setBloqueado(rs.getInt("estado") == 1);
                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Bloquear ou desbloquear
    public void atualizarStatus(String matricula, boolean bloqueado) {
        String sql = "UPDATE cadastro SET estado = ? WHERE matricula = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, bloqueado ? 1 : 0);
            ps.setString(2, matricula);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Excluir usuário/chave
    public void excluirUsuario(String matricula) {
        String sql = "DELETE FROM cadastro WHERE matricula = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, matricula);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Buscar usuário por matrícula
    public Usuario buscarPorMatricula(String matricula) {
        String sql = "SELECT matricula, nome, bloco, ap, email, tipo_usuario, estado FROM cadastro WHERE matricula = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, matricula);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario(
                        rs.getString("matricula"),
                        rs.getString("nome"),
                        rs.getString("bloco"),
                        rs.getString("ap"),
                        "", // senha não trazemos
                        rs.getString("email"),
                        rs.getString("tipo_usuario")
                    );
                    u.setBloqueado(rs.getInt("estado") == 1);
                    return u;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
    
}
