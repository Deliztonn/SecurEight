<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Histórico de Acesso</title>
  <link rel="stylesheet" href="HistoricoUser.css">
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
      <a href="MenuUser.jsp">
      <img src="../images/WhatsApp_Image_2025-10-07_at_19.55.40-removebg-preview.png" alt="Logo" class="logo">
      </a>
      <h1>Histórico de Acesso - Nome Usuário</h1>
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
          <th>Ação</th>
          <th>Horário</th>
          <th>Dia/Mês</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Você entrou em: Piscina</td>
          <td>00:08</td>
          <td>29/11</td>
        </tr>
        <tr>
          <td>Você entrou em: Recepção</td>
          <td>00:02</td>
          <td>01/11</td>
        </tr>
        <tr>
          <td>Você entrou em: Elevador</td>
          <td>21:00</td>
          <td>28/09</td>
        </tr>
      </tbody>
    </table>
  </div>
</body>
</html>
