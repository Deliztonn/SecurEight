<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.schutele.DAO.ConnectionFactory" %>

<!DOCTYPE html>

<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Histórico de Acesso</title>
  <link rel="stylesheet" href="HistoricoADM.css">
  <script>
    function atualizarHorario() {
      const agora = new Date();
      const horas = agora.getHours().toString().padStart(2, '0');
      const minutos = agora.getMinutes().toString().padStart(2, '0');
      const dia = agora.getDate().toString().padStart(2, '0');
      const mes = (agora.getMonth() + 1).toString().padStart(2, '0');

      document.getElementById('hora').textContent = `${horas}:${minutos}`;
      document.getElementById('data').textContent = `${dia}/${mes}`;
    }

    setInterval(atualizarHorario, 1000);
    window.onload = atualizarHorario;

  </script>
</head>
<body>
  <div class="top-bar">
    <div class="logo-titulo">
      <a href="MenuADM.jsp">
        <img src="../images/logo.png" alt="Logo" class="logo">
      </a>
      <h1>Histórico de Acesso</h1>
    </div>
    <div class="hora-data">
      <span id="hora">00:00</span><br>
      <span id="data">00/00</span>
    </div>
  </div>

  <div class="tabela-container">
    <table>
      <thead>
        <tr>
          <th>Nome</th>
          <th>Ação</th>
          <th>Horário</th>
          <th>Dia/Mês</th>
        </tr>
      </thead>
      <tbody>
        <%
          Connection conn = null;
          PreparedStatement ps = null;
          ResultSet rs = null;

          try {
            conn = ConnectionFactory.getConnection();
            String sql = "SELECT nome, acao, data_leitura FROM registros ORDER BY data_leitura DESC";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String acao = rs.getString("acao");
                Timestamp ts = rs.getTimestamp("data_leitura");
                String horario = "";
                String data = "";

                if (ts != null) {
                    java.time.LocalDateTime ldt = ts.toLocalDateTime();
                    horario = ldt.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"));
                    data = ldt.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM"));
                }
        %>
        <tr>
          <td><%= nome %></td>
          <td><%= acao %></td>
          <td><%= horario %></td>
          <td><%= data %></td>
        </tr>
        <%
            }
          } catch (SQLException e) {
            out.println("<tr><td colspan='4'>Erro ao carregar histórico: " + e.getMessage() + "</td></tr>");
          } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (ps != null) try { ps.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
          }
        %>
      </tbody>
    </table>

  </div>
</body>
</html>
