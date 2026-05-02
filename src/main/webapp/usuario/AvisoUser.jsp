<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Central de Avisos</title>
<link rel="stylesheet" href="AvisoUser.css">
</head>
<body>

	<div class="container">

		<a href="MenuUser.jsp">
			<h1>
				<img src="../images/logob.png" class="logo" alt="Logo">
			</h1>
		</a>
		<div class="avisos-box">

			<h2>Central de Avisos do Condomínio</h2>

			<form action="<%= request.getContextPath() %>/aviso" method="post">
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
	</div>

</body>
</html>
