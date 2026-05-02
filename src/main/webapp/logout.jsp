<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.schutele.model.Usuario"%>

<%
    Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

    if (usuarioLogado == null) {
        response.sendRedirect("Login.jsp");
        return;
    }

    String paginaAnterior = request.getHeader("referer");
    if (paginaAnterior == null) {
        paginaAnterior = request.getContextPath() + "/adm/MenuA.jsp"; // fallback
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfil do Usuário</title>

<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        height: 100vh;
        overflow: hidden;
    }

    .background {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        object-fit: cover;
        z-index: 1;
    }

    .overlay {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0,0,0,0.5);
        z-index: 2;
    }

    .container {
        width: 450px;
        margin: 60px auto;
        background: white;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0px 0px 20px rgba(0,0,0,0.2);
        text-align: center;
        position: relative;
        z-index: 3;
    }

    .avatar {
        width: 120px;
        height: 120px;
        border-radius: 50%;
        object-fit: cover;
        border: 3px solid black;
        margin-bottom: 20px;
    }

    .close-x {
        position: absolute;
        top: 20px;
        right: 20px;
        width: 28px;
        height: 28px;
        cursor: pointer;
        z-index: 9999;
    }

    h2 {
        margin-bottom: 15px;
    }

    .info {
        text-align: left;
        margin-top: 20px;
        font-size: 18px;
        line-height: 28px;
    }

    .logout-btn {
        margin-top: 30px;
        padding: 12px 40px;
        background-color: #d9534f;
        color: white;
        border: none;
        border-radius: 10px;
        font-size: 18px;
        cursor: pointer;
    }

    .logout-btn:hover {
        background-color: #c9302c;
    }
</style>
</head>

<body>

<img src="<%= request.getContextPath() %>/images/logout1.jpg" class="background">

<div class="overlay"></div>

<div class="container">

    <img src="<%= request.getContextPath() %>/images/x.png"
         class="close-x"
         onclick="window.location.href='<%= paginaAnterior %>'">

    <img src="<%= request.getContextPath() %>/images/avatar.webp" class="avatar">

    <h2>Bem-vindo, <%= usuarioLogado.getNome() %>!</h2>

    <div class="info">
        <p><strong>Nome:</strong> <%= usuarioLogado.getNome() %></p>
        <p><strong>Email:</strong> <%= usuarioLogado.getEmail() %></p>
        <p><strong>Tipo de Usuário:</strong> <%= usuarioLogado.getTipoUsuario() %></p>
        <p><strong>Bloco:</strong> <%= usuarioLogado.getBloco() %></p>
        <p><strong>Ap:</strong> <%= usuarioLogado.getAp() %></p>
    </div>

    <a href="<%= request.getContextPath() %>/logout">
        <button class="logout-btn">Logout</button>
    </a>

</div>

</body>
</html>
