<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>SecurEight</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    .bg-custom-blue {
      background-color: rgba(132, 171, 230, 0.7) !important;
    }

    body {
      overflow-x: hidden;
    }

    .posicao-personalizada {
      top: 80px;
      left: 150px;
    }

    .tamanho {
      width: 500px;
      height: 500px;
      font-size: 38px;
      color: black;
      border-radius: 35px; /* mais arredondado */
    }

    .email {
      display: flex;
      gap: 10px;
      font-size: 25px;
      color: black;
    }

    .e2 {
      display: flex;
      gap: 10px;
    }

    .conta {
      margin-left: -16px;
      font-size: 30px;
    }

    input {
      border-radius: 20px; /* bordas arredondadas nos campos */
      border: 1px solid #ccc;
      padding: 6px 10px;
    }

    .botao {
      margin-left: 120px;
      margin-top: 20px;
      font-size: 20px;
      border-radius: 25px; /* mais arredondado */
      padding: 10px 40px;
      background-color: #3B5ABE;
      color: white;
      border: none;
    }

    .botao:hover {
      background: rgba(106, 137, 184, 0.9);
    }
  </style>
</head>

<body>
  <div style="background-color:#3B5ABE; color:white; padding:15px;">
    <p style="font-size:40px; margin-left:150px; margin-top:10px;">SecurEight</p>

    <img src="images/logo.png"
         style="width:180px; height:130px; position:absolute; top:-13px; left:0px;">

    <img src="images/aviso01.jpeg"
         style="width:100%; height:90%; position:absolute; top:115px; left:0px;">
  </div>

  <div class="position-relative">
    <div class="position-absolute p-4 rounded bg-custom-blue posicao-personalizada tamanho text-center">
      <h4 class="conta"><b>Acessar Conta</b></h4>

      <div class="col-lg-8">
        <form action="login" method="POST">
          <div class="email">
            <div class="mb-3">
              <label for="email" class="mt-5"><b>Email</b></label>
            </div>
          </div>

          <div class="e2">
            <div class="mb-3">
              <input type="email" id="email" class="form-label mt--3" name="email">
            </div>
          </div>

          <div class="email">
            <div class="mb-6">
              <label for="password" class="mt-6"><b>Senha</b></label>
            </div>
          </div>

          <div class="e2">
            <div class="mb-3">
              <input type="password" id="password" class="form-label mt-3" name="senha">
            </div>
          </div>

          <div>
            <button class="botao">Confirmar</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</body>
</html>
