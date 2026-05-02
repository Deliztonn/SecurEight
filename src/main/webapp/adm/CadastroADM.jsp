<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    .bg-custom-blue {
        background-color: rgba(132, 171, 230, 0.9) !important;
    }

    body {
        overflow-x: hidden;
    }

    .posicao-personalizada {
        top: 20px;
        left: 470px;
    }

    .tamanho {
        width: 500px;
        font-size: 18px;
        color: black;
    }

    .conta {
        font-size: 30px;
        margin-bottom: 30px; /* espaço abaixo do título */
    }

    .botao {
        margin-top: 20px;
        font-size: 20px;
        border-radius: 18px;
        padding: 10px 40px;
        background-color: #3B5ABE;
        color: white;
        border: none;
    }

 
</style>


     <script>
		function minhaFuncao() {
		  alert("O cadastro foi um sucesso!");
		}
	</script>
       
</head>

<body>
    <div style="background-color:#3B5ABE; color:white; padding:20px;">
        <p style="font-size:40px; margin-left:150px; margin-top:10px;">
            SecurEight
        </p>

          <a href="MenuADM.jsp">
       <img src="../images/logo.png" 
             style="width:180px; height:130px; position:absolute; top:-13px; left:0px;">
    </a>
       
        <img src="../images/opc1.jpeg" 
             style="width:100%; height:130%; position:absolute; top:126px; left:0px;">
    </div>

    <div class="position-relative">
        <div class="position-absolute p-5 rounded bg-custom-blue posicao-personalizada tamanho text-center">
            <h4 class="conta"><b>Cadastro</b></h4>

      <form action="cadastrar" method="post"> 

        <!-- CAMPO NOVO: MATRÍCULA -->
        <div class="mb-3 text-start">
            <label for="matricula" class="form-label"><b>Matrícula</b></label>
            <input type="text" id="matricula" class="form-control" name="matricula" required>
        </div>

        <div class="mb-3 text-start">
            <label for="nome" class="form-label"><b>Nome</b></label>
            <input type="text" id="nome" class="form-control" name="nome">
        </div>

        <div class="mb-3 text-start">
            <label for="bloco" class="form-label"><b>Bloco</b></label>
            <input type="text" id="bloco" class="form-control" name="bloco">
        </div>

        <div class="mb-3 text-start">
            <label for="ap" class="form-label"><b>Ap</b></label>
            <input type="text" id="ap" class="form-control" name="ap">
        </div>

        <div class="mb-3 text-start">
            <label for="email" class="form-label"><b>Email</b></label>
            <input type="email" id="email" class="form-control" name="email">
        </div>

        <div class="mb-3 text-start">
            <label for="password" class="form-label"><b>Senha</b></label>
            <input type="password" id="password" class="form-control" name="senha">
        </div>

        <div class="mb-3 text-start">
            <label for="funcao" class="form-label"><b>Função</b></label>
            <select id="funcao" class="form-select" name="funcao" required>
                <option value="" disabled selected>Selecione a função</option>
                <option value="adm">Administrador (adm)</option>
                <option value="usuario">Usuário</option>
            </select>
        </div>

        <button type="submit" class="botao" onclick="minhaFuncao()">Confirmar</button>
</form>

        </div>
    </div>
</body>
</html>
