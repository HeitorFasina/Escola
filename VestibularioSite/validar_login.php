<?php

session_start();
require_once "conexao.php";

if (empty($_POST['usuario']) || empty($_POST['senha'])) {
    header('Location: index.php');
    exit;
}

$usuario = $_POST['usuario'];
$senha = $_POST['senha'];

$query = "SELECT * FROM usuarios WHERE usuario = '$usuario' AND senha = md5('$senha');";

$result = mysqli_query($conn, $query);
if ($result->num_rows == 0) {
    $_SESSION['nao_validado'] = true;
    header('Location: index.php');
    exit;
} else {
    $row = $result->fetch_assoc();
    $_SESSION['user_id'] = $row['ID'];
    $_SESSION['user_nome'] = $row['nome'];
}
