<?php

session_start();
require_once "conexao.php";

if (empty($_POST['usuario']) || empty($_POST['senha'])) {
    header('Location: index.php');
    exit;
}

$usuario = $_POST['usuario'];
$senha = $_POST['senha'];

$query = "SELECT * FROM login WHERE usuario = '$usuario' AND senha = md5('$senha');";

$result = mysqli_query($conn, $query);

if ($result->num_rows == 0) {
    $_SESSION['nao_validado'] = true;
    print("Login not succes");
    echo $usuario . " " . $senha;
    header('Location: index.php');
    exit;
} else {
    print("Login Successful... Welcome ");
}
