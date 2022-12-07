<?php

session_start();
require_once "conexao.php";

if (empty($_POST['nome']) || empty($_POST['usuario']) || empty($_POST['senha'])) {
    $_SESSION['campo_invalido'] = true;
    header('Location: pagina_cadastro.php');
    exit;
}

$nome = $_POST['nome'];
$usuario = $_POST['usuario'];
$senha = $_POST['senha'];

$query = "INSERT INTO login VALUES (NULL, '$nome', '$usuario', md5('$senha'));";

$result = mysqli_query($conn, $query);

$result = mysqli_query($conn, "SET @num := 0;");
$result = mysqli_query($conn, "UPDATE login SET ID = @num := (@num+1)");
$result = mysqli_query($conn, "ALTER TABLE login AUTO_INCREMENT = 1");

if ($result) {
    $_SESSION['cadastrado'] = true;
    header('Location: index.php');
    exit;
} else {
    $_SESSION['erro_cadastro'] = true;
    header('Location: index.php');
    exit;
}
