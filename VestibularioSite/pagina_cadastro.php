<?php
session_start();
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro</title>
    <link href="style.css" rel="stylesheet">
</head>

<body>
    <h1>Cadastro</h1>

    <hr>

    <?php
    if (isset($_SESSION['campo_invalido'])) {
        echo '<script type="text/javascript">alert("Todos os campos devem ser preenchidos.");</script>';
    }
    unset($_SESSION['campo_invalido']);
    ?>

    <div class="container">
        <form action="cadastro.php" method="post">
            Digite seu nome: <input type="text" name="nome" id=""> <br>
            Digite o nome de usuário que deseja: <input type="text" name="usuario" id=""> <br>
            Digite a senha que deseja: <input type="password" name="senha" id=""> <br> <br>
            <button type="submit">Cadastrar</button>
        </form>
    </div>
</body>

</html>