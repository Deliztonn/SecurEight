<%
    // Verifica se o usuário está logado e é ADM
    String usuarioLogado = (String) session.getAttribute("usuarioLogado");
    String tipoUsuario = (String) session.getAttribute("tipoUsuario");

    if (usuarioLogado == null || tipoUsuario == null || !tipoUsuario.equalsIgnoreCase("adm")) {
        response.sendRedirect("Login.jsp");
        return;
    }
%>

Bem-vindo, Administrador <%= usuarioLogado %>!
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

    /* Imagem de fundo geral */
    .background {
        position: fixed;
        top: 0;
        left: 0;
        width: 100vw;
        height: 100vh;
        object-fit: cover;
        z-index: 1;
    }

    /* Barra lateral */
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

    /* Logo */
    .logo {
        width: 70%;
        height: auto;
        margin-bottom: 20px;
        position: relative;
        z-index: 11;
    }

    /* Menu título */
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

    /* Botões */
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
</style>
</head>

<body>

<!-- Imagem de fundo -->
<img src="Images/opc10.jpeg" class="background" alt="Fundo">

<!-- Barra lateral -->
<div class="barra">

    <img src="Images/logo.png" class="logo" alt="Logo">

    <p class="menu">Menu</p>

    <a href="editarchave.html"> 
        <button type="button" class="botao" style="padding: 20px 95px">Editar Chave</button>
    </a>

    <a href="AvisoA.jsp">
        <button type="button" class="botao" style="padding: 20px 78px">Central de Avisos</button>
    </a>

    <a href="historico.html">
        <button type="button" class="botao">Histórico de acesso</button>
    </a>

    <a href="CadastroA.jsp">
        <button type="button" class="botao" style="padding: 20px 108px">Cadastrar</button>
    </a>

</div>

</body>
</html>
