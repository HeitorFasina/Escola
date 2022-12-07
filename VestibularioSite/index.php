<?php
session_start();
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vestibulário Web Site</title>
    <link href="style.css" rel="stylesheet">
</head>

<body>
    <h1>Login</h1>

    <hr>

    <?php
    if (isset($_SESSION['nao_validado'])) {
        echo '<script type="text/javascript">alert("Usuário ou senha incorreto.");</script>';
    }
    unset($_SESSION['nao_validado']);

    if (isset($_SESSION['cadastrado'])) {
        echo '<script type="text/javascript">alert("Você foi registrado!");</script>';
    }
    unset($_SESSION['cadastrado']);

    if (isset($_SESSION['erro_cadastro'])) {
        echo '<script type="text/javascript">alert("Ocorreu um erro.");</script>';
    }
    unset($_SESSION['erro_cadastro']);
    ?>

    <div class="container">
        <form action="pagina_principal.php" method="post">
            Digite seu usuário: <input type="text" name="usuario" id=""> <br>
            Digite sua senha: <input type="password" name="senha" id=""> <br> <br>
            <button type="submit">Entrar</button>
        </form>
        <br> <br>
        <a href="pagina_cadastro.php">Caso ainda não tenha um cadastro, clique aqui.</a>
    </div>
</body>

</html>