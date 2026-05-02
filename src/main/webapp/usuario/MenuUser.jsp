<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <link rel="stylesheet" href="MenuUser.css">
</head>

<body>

<div class="sidebar">

    <a href="<%= request.getContextPath() %>/logout.jsp">
        <img src="../images/avatar.webp" class="avatar">
    </a>

    <img src="../images/WhatsApp_Image_2025-10-07_at_19.55.40-removebg-preview.png" class="logo">

    <h1 class="menu-title">Menu</h1>

    <a class="btn" href="EditarChaveUser.html">Editar Chave</a>
    <a class="btn" href="AvisoUser.jsp">Central de Avisos</a>
    <a class="btn" href="HistoricoUser.jsp">Histórico de acesso</a>

</div>

</body>
</html>
