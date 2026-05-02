<%@ page import="com.schutele.DAO.UsuarioDAO" %>
<%@ page import="com.schutele.model.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Editar Chave de Acesso</title>
<link rel="stylesheet" href="editarchave.css">
</head>
<body>

<header class="topbar">
    <div class="topbar-inner">
        <a href="MenuADM.jsp"><img src="../images/logo.png" alt="Logo do condomínio"></a>
        <h1>Editar Chave de Acesso</h1>
    </div>
</header>

<main class="page">
    <div class="left-panel">
        <div class="left-content">
            <%
                UsuarioDAO dao = new UsuarioDAO();
                List<Usuario> usuarios = dao.listarTodos();
                for (Usuario u : usuarios) {
            %>
            <form action="AtualizarStatusUsuarioServlet" method="post">
                <input type="hidden" name="matricula" value="<%=u.getMatricula()%>">
                <p><strong><%=u.getNome()%></strong> - <%=u.getBloco()%> Ap <%=u.getAp()%></p>
                <button type="submit" name="acao" value="bloquear" <%=u.isBloqueado()?"disabled":""%>>Bloquear</button>
                <button type="submit" name="acao" value="desbloquear" <%=!u.isBloqueado()?"disabled":""%>>Desbloquear</button>
            </form>
            <form action="ExcluirUsuarioServlet" method="post">
                <input type="hidden" name="matricula" value="<%=u.getMatricula()%>">
                <button type="submit">Excluir</button>
            </form>
            <hr>
            <% } %>
        </div>
    </div>
</main>

</body>
</html>