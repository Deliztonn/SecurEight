    package com.schutele.DAO;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;

    // Se você usa ResultSet no CadastrarDAO (para métodos de busca), adicione:
    // import java.sql.ResultSet; 


    public class CadastrarDAO {
        public void cadastrarUsuario(CadastrarAtributos u) {
            // **Ajuste:** Inclua 'tipo_usuario' na sua query SQL
            // Certifique-se de que o nome da coluna 'tipo_usuario' está correto no seu banco de dados
            String sql = "INSERT INTO cadastro (nome, bloco, ap, email, senha, tipo_usuario) VALUES (?, ?, ?, ?, ?, ?)";
            
            try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                    
                stmt.setString(1, u.getNome());
                stmt.setString(2, u.getBloco());
                stmt.setString(3, u.getAp());
                stmt.setString(4, u.getEmail());
                stmt.setString(5, u.getSenha());
                stmt.setString(6, u.getTipoUsuario()); // <-- NOVO PARÂMETRO
                
                stmt.executeUpdate();
                
            } catch (SQLException e) {
                System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }