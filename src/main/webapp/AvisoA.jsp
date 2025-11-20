<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SecurEight</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

.quadrado{
height: 350px;
width: 450px;
background-color: white;
border:2px solid black;
border-radius: 15px;
position: absolute;
}

.botao{
background-color: white;
position: absolute;
border-radius: 10px;
font-size: 25px;
padding: 20px;

}

.botao:hover{
background: #d3d3d3;
}




</style>
<body>
<div style="background-color:#3B5ABE; color:white; padding:20px;">
        <p style="font-size:40px; margin-left:150px; margin-top:10px;">
            Avisos
        </p>

        <img src="Images/logo.png" 
             style="width:180px; height:130px; position:absolute; top:-13px; left:0px;">

        <img src="Images/Aviso.png" 
             style="width:100%; height:100%; position:absolute; top:126px; left:0px;">
    </div>
    
    <button class="botao" style="margin-left:80%; margin-top: 150px; padding: 10px 80px">Editar</button>
    <button class="botao" style="margin-left:80%; margin-top: 230px; padding: 10px 63px">Remover</button>

	<div class="quadrado" style="margin-left: 100px; margin-top: 25px">
	
	</div>
	
	
	<div class="quadrado" style="margin-left: 100px; margin-top: 390px">

	</div>

</body>
</html>