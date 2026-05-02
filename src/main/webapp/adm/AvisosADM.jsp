<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Central de Avisos</title>

<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background: url("<%= request.getContextPath() %>/images/aviso02.jpg") no-repeat center center fixed;
        background-size: cover;
    }

    .container {
        width: 60%;
        margin: 50px auto;
        background: rgba(255, 255, 255, 0.92);
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.2);
        position: relative;
        z-index: 5;
    }

    textarea {
        width: 100%;
        height: 100px;
        padding: 10px;
        border-radius: 6px;
        border: 1px solid #ccc;
        font-size: 15px;
        resize: none;
        background: rgba(255,255,255,0.85);
    }

    button {
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        margin-top: 10px;
    }

    button:hover {
        background-color: #0056b3;
    }

    .avisos {
        margin-top: 30px;
        border: 1px solid #ddd;
        border-radius: 8px;
        padding: 15px;
        min-height: 150px;
        background-color: rgba(250, 250, 250, 0.9);
        box-shadow: inset 0 0 6px rgba(0,0,0,0.05);
    }

    .aviso {
        background-color: rgba(248, 249, 250, 0.9);
        border-left: 4px solid #007bff;
        padding: 10px;
        margin-bottom: 10px;
        border-radius: 4px;
    }

    .sem-aviso {
        text-align: center;
        color: #555;
        font-style: italic;
    }
</style>

</head>
<body>

<a href="<%= request.getContextPath() %>/adm/MenuADM.jsp">
    <img src="<%= request.getContextPath() %>/images/logo.png" 
         style="width:180px; height:130px; position:absolute; top:-13px; left:0px;">
</a>

<div class="container">
    <h2>Central de Avisos do Condomínio</h2>

    <form action="<%= request.getContextPath() %>/aviso" method="post">
        <textarea name="mensagem" placeholder="Digite um novo aviso..."></textarea>
        <button type="submit">Publicar Aviso</button>
    </form>

    <div class="avisos">
        <h3>Avisos Recentes:</h3>

        <%
            java.util.List<String> avisos = (java.util.List<String>) request.getAttribute("avisos");
            if (avisos != null && !avisos.isEmpty()) {
                for (String aviso : avisos) {
        %>
                    <div class="aviso"><%= aviso %></div>
        <%
                }
            } else {
        %>
                <div class="sem-aviso">Nenhum aviso publicado ainda.</div>
        <%
            }
        %>
    </div>
</div>

</body>
</html>
