<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.schutele.model.Usuario" %>


<%
    Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

    if (usuarioLogado == null || 
        !usuarioLogado.getTipoUsuario().equalsIgnoreCase("adm")) {

        response.sendRedirect(request.getContextPath() + "/Login.jsp");
        return;
    }

    String nome = usuarioLogado.getNome();
%>

Bem-vindo, Administrador <%= nome %>!


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SecurEigth</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body, html {
        margin: 0;
        padding: 0;
        height: 100%;
        width: 100%;
    }

    .background {
        position: fixed;
        top: 0;
        left: 0;
        width: 100vw;
        height: 100vh;
        object-fit: cover;
        z-index: 1;
    }

    .barra {
        position: fixed;
        top: 0;
        left: 0;
        width: 20vw;
        height: 100vh;
        background-color: rgba(65, 85, 180, 0.7);
        color: white;
        display: flex;
        flex-direction: column;
        align-items: center;
        z-index: 10;
        padding-top: 20px;
        box-sizing: border-box;

    }

    .logo {
        width: 70%;
        height: auto;
        margin-bottom: 20px;
        position: relative;
        z-index: 11;
    }

    .menu {
        font-size: 2.5vw;
        font-weight: bold;
        width: 20vw;
        height: 10vh;
        line-height: 10vh;
        text-align: center;
        background-color: rgba(132, 171, 230, 0.9);
        border: 3px solid rgba(132, 171, 230, 0.9);
        margin-bottom: 20px;
        position: relative;
        z-index: 11;
    }

    .botao {
        margin-top: 20px;
        font-size: 18px;
        border-radius: 18px;
        padding: 20px 70px;
        background-color: rgba(132, 171, 230, 0.9);
        color: white;
        border: none;
        position: relative;
        z-index: 11;

    }

    .botao:hover {
        background: rgba(106, 137, 184, 0.9);
    }

   .avatar {
        position: absolute;
        top: 40px;
        left: 1370px;
        width: 100px;
        height: auto;
        object-fit: cover;
        border-radius: 50%;
        border: 4px solid black;
        z-index: 20;
    }
</style>
</head>

<body>

<img src="../images/opc10.jpeg" class="background">


<a href="<%= request.getContextPath() %>/logout.jsp">
        <img src="../images/avatar.webp" class="avatar">
    </a>

<div class="barra">

    <img src="../images/logo.png" class="logo">

    <p class="menu">Menu</p>

    <a href="EditarChaveADM.jsp"> 
        <button type="button" class="botao" style="padding: 20px 95px">Editar Chave</button>
    </a>

    <a href="../aviso">
        <button type="button" class="botao" style="padding: 20px 78px">Central de Avisos</button>
    </a>

    <a href="HistoricoADM.jsp">
        <button type="button" class="botao">Histórico de acesso</button>
    </a>

    <a href="CadastroADM.jsp">
        <button type="button" class="botao" style="padding: 20px 108px"> Cadastrar </button>
    </a>

</div>

</body>
</html>
